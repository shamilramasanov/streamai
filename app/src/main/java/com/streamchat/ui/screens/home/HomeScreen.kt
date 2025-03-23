package com.streamchat.ui.screens.home

import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.streamchat.R
import com.streamchat.platforms.core.MessageType
import com.streamchat.platforms.core.PlatformType
import com.streamchat.platforms.core.StreamMessage
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val messages by viewModel.messages.collectAsState()
    val stats by viewModel.stats.collectAsState()
    val selectedPlatform by viewModel.selectedPlatform.collectAsState()
    val selectedMessageType by viewModel.selectedMessageType.collectAsState()
    val isAutomaticTranslationEnabled by viewModel.isAutomaticTranslationEnabled.collectAsState()

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val totalHeight = this.maxHeight
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ConnectSection(
                onConnectClick = { url -> viewModel.connect(url) },
                onDisconnectClick = { viewModel.disconnect() },
                isConnected = selectedPlatform != null
            )
            
            if (selectedPlatform != null) {
                Spacer(modifier = Modifier.height(16.dp))
                
                StatsSection(
                    stats = stats,
                    selectedPlatform = selectedPlatform.toString(),
                    onTranslationToggle = { viewModel.toggleAutomaticTranslation() },
                    isAutomaticTranslationEnabled = isAutomaticTranslationEnabled
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                FilterSection(
                    selectedMessageType = selectedMessageType,
                    onFilterChange = { viewModel.selectMessageType(it) }
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(totalHeight - 350.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(
                        items = messages,
                        key = { it.id }
                    ) { message ->
                        MessageItem(message = message)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectSection(
    onConnectClick: (String) -> Unit,
    onDisconnectClick: () -> Unit,
    isConnected: Boolean
) {
    var url by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    val platformOptions = listOf("YouTube", "TikTok")
    var selectedPlatform by remember { mutableStateOf(platformOptions.first()) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Підключення до трансляції",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    TextField(
                        value = selectedPlatform,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = when (selectedPlatform) {
                                    "YouTube" -> Icons.Default.PlayArrow
                                    "TikTok" -> Icons.Default.Star
                                    else -> Icons.Default.PlayArrow
                                },
                                contentDescription = null,
                                tint = when (selectedPlatform) {
                                    "YouTube" -> Color.Red
                                    "TikTok" -> Color(0xFF00F2EA)
                                    else -> Color.Gray
                                }
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(),
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )
                    
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        platformOptions.forEach { option ->
                            DropdownMenuItem(
                                text = { Text(text = option) },
                                leadingIcon = {
                                    Icon(
                                        imageVector = when (option) {
                                            "YouTube" -> Icons.Default.PlayArrow
                                            "TikTok" -> Icons.Default.Star
                                            else -> Icons.Default.PlayArrow
                                        },
                                        contentDescription = null,
                                        tint = when (option) {
                                            "YouTube" -> Color.Red
                                            "TikTok" -> Color(0xFF00F2EA)
                                            else -> Color.Gray
                                        }
                                    )
                                },
                                onClick = {
                                    selectedPlatform = option
                                    expanded = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                TextField(
                    value = url,
                    onValueChange = { url = it },
                    label = { Text("URL трансляції") },
                    placeholder = {
                        Text(
                            when (selectedPlatform) {
                                "YouTube" -> "Наприклад: https://www.youtube.com/watch?v=..."
                                "TikTok" -> "Наприклад: https://www.tiktok.com/@username/live"
                                else -> "Введіть URL"
                            }
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = {
                            val formattedUrl = when (selectedPlatform) {
                                "YouTube" -> {
                                    if (!url.contains("youtube.com") && !url.contains("youtu.be")) {
                                        "https://www.youtube.com/watch?v=$url"
                                    } else {
                                        url
                                    }
                                }
                                "TikTok" -> {
                                    if (!url.contains("tiktok.com")) {
                                        "https://www.tiktok.com/@$url/live"
                                    } else {
                                        url
                                    }
                                }
                                else -> url
                            }
                            onConnectClick(formattedUrl)
                        },
                        enabled = !isConnected && url.isNotBlank(),
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = when (selectedPlatform) {
                                "YouTube" -> Color.Red
                                "TikTok" -> Color(0xFF00F2EA)
                                else -> MaterialTheme.colorScheme.primary
                            }
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Підключитися")
                    }
                    
                    Button(
                        onClick = { onDisconnectClick() },
                        enabled = isConnected,
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Gray
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = null
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Відключитися")
                    }
                }
            }
        }
    }
}

@Composable
fun MessageItem(message: StreamMessage) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = when (message.platform) {
                PlatformType.YOUTUBE -> MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.1f)
                PlatformType.TIKTOK -> MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f)
                PlatformType.UNKNOWN -> MaterialTheme.colorScheme.surfaceVariant
            }
        ),
        border = BorderStroke(
            width = 1.dp,
            color = when (message.platform) {
                PlatformType.YOUTUBE -> MaterialTheme.colorScheme.error.copy(alpha = 0.2f)
                PlatformType.TIKTOK -> MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                PlatformType.UNKNOWN -> MaterialTheme.colorScheme.outline
            }
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = message.author,
                    style = MaterialTheme.typography.titleMedium
                )
                Icon(
                    painter = painterResource(
                        id = when (message.platform) {
                            PlatformType.YOUTUBE -> R.drawable.ic_youtube
                            PlatformType.TIKTOK -> R.drawable.ic_tiktok
                            PlatformType.UNKNOWN -> R.drawable.ic_error
                        }
                    ),
                    contentDescription = message.platform.name,
                    tint = when (message.platform) {
                        PlatformType.YOUTUBE -> MaterialTheme.colorScheme.error
                        PlatformType.TIKTOK -> MaterialTheme.colorScheme.primary
                        PlatformType.UNKNOWN -> MaterialTheme.colorScheme.outline
                    },
                    modifier = Modifier.size(20.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = message.text,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )

            message.gifts?.let { gifts ->
                if (gifts.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "🎁 ${gifts.joinToString { "${it.name} (${it.value})" }}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            message.likes?.let { likes ->
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "❤️ $likes",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
fun FilterSection(
    selectedMessageType: MessageType,
    onFilterChange: (MessageType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        MessageType.values().forEach { type ->
            FilterChip(
                selected = type == selectedMessageType,
                onClick = { onFilterChange(type) },
                label = {
                    Text(
                        when (type) {
                            MessageType.REGULAR -> "Повідомлення"
                            MessageType.QUESTION -> "Питання"
                            MessageType.PERSONAL_QUESTION -> "Особисті"
                            MessageType.GIFT -> "Подарунки"
                            MessageType.SYSTEM -> "Системні"
                            MessageType.GRATITUDE -> "Подяки"
                        }
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = when (type) {
                        MessageType.QUESTION -> MaterialTheme.colorScheme.primaryContainer
                        MessageType.PERSONAL_QUESTION -> MaterialTheme.colorScheme.secondaryContainer
                        MessageType.GIFT -> MaterialTheme.colorScheme.tertiaryContainer
                        MessageType.GRATITUDE -> MaterialTheme.colorScheme.surfaceVariant
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    }
                )
            )
        }
    }
}

@Composable
fun StatsSection(
    stats: Map<PlatformType, Int>,
    selectedPlatform: String,
    onTranslationToggle: () -> Unit,
    isAutomaticTranslationEnabled: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                "Статистика стріму",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                "Всього повідомлень: ${stats.values.sum()}",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            stats.forEach { (platform, count) ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(
                                id = when (platform) {
                                    PlatformType.YOUTUBE -> R.drawable.ic_youtube
                                    PlatformType.TIKTOK -> R.drawable.ic_tiktok
                                    PlatformType.UNKNOWN -> R.drawable.ic_error
                                }
                            ),
                            contentDescription = platform.toString(),
                            tint = when (platform) {
                                PlatformType.YOUTUBE -> MaterialTheme.colorScheme.error
                                PlatformType.TIKTOK -> MaterialTheme.colorScheme.primary
                                PlatformType.UNKNOWN -> MaterialTheme.colorScheme.outline
                            },
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            when (platform) {
                                PlatformType.YOUTUBE -> "YouTube"
                                PlatformType.TIKTOK -> "TikTok"
                                PlatformType.UNKNOWN -> "Невідома платформа"
                            },
                            style = MaterialTheme.typography.bodyMedium,
                            color = when (platform) {
                                PlatformType.YOUTUBE -> MaterialTheme.colorScheme.error
                                PlatformType.TIKTOK -> MaterialTheme.colorScheme.primary
                                PlatformType.UNKNOWN -> MaterialTheme.colorScheme.outline
                            }
                        )
                    }
                    Text(
                        "$count",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Автоматичний переклад",
                    style = MaterialTheme.typography.bodyMedium
                )
                Switch(
                    checked = isAutomaticTranslationEnabled,
                    onCheckedChange = { onTranslationToggle() },
                    enabled = true
                )
            }
        }
    }
} 