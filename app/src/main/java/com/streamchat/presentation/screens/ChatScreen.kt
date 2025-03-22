package com.streamchat.presentation.screens

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.streamchat.domain.model.ChatMessage
import com.streamchat.domain.model.MessageType
import com.streamchat.presentation.viewmodels.ChatViewModel
import com.streamchat.data.remote.YouTubeApiService
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(
    streamUrl: String,
    viewModel: ChatViewModel,
    onNavigateBack: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val messages by viewModel.allMessages.collectAsState()
    val questions by viewModel.questions.collectAsState()
    val gratitude by viewModel.gratitude.collectAsState()
    val personalQuestions by viewModel.personalQuestions.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()
    val chatMood by viewModel.chatMood.collectAsState()
    
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Всі", "Питання", "Подяки", "Особисті")
    val currentMessages = when (selectedTab) {
        0 -> messages
        1 -> questions
        2 -> gratitude
        3 -> personalQuestions
        else -> messages
    }

    LaunchedEffect(streamUrl) {
        Log.v("StreamChat", "🎬 ChatScreen: LaunchedEffect з URL: '$streamUrl'")
        if (streamUrl.isNotBlank()) {
            try {
                Log.v("StreamChat", "🔄 Спроба підключення до чату з URL: '$streamUrl'")
                viewModel.connectToChat(streamUrl.trim())
                Log.v("StreamChat", "✅ Успішно підключено до чату")
            } catch (e: Exception) {
                Log.e("StreamChat", "❌ Помилка підключення до чату: ${e.message}", e)
            }
        } else {
            Log.v("StreamChat", "⚠️ URL є порожнім")
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            scope.launch {
                viewModel.stopChat()
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(
                            text = "Чат трансляції",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = streamUrl,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            viewModel.stopChat()
                            onNavigateBack()
                        }
                    }) {
                        Icon(Icons.Default.ArrowBack, "Назад")
                    }
                },
                actions = {
                    Text(
                        text = when {
                            chatMood >= 0.7 -> "😊"
                            chatMood >= 0.4 -> "😐"
                            else -> "😔"
                        },
                        fontSize = 24.sp
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TabRow(
                selectedTabIndex = selectedTab,
                modifier = Modifier.fillMaxWidth()
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = {
                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(title)
                                Spacer(Modifier.width(4.dp))
                                Text(
                                    text = when (index) {
                                        0 -> "${messages.size}"
                                        1 -> "${questions.size}"
                                        2 -> "${gratitude.size}"
                                        3 -> "${personalQuestions.size}"
                                        else -> "0"
                                    },
                                    style = MaterialTheme.typography.labelSmall
                                )
                            }
                        }
                    )
                }
            }
            
            Box(modifier = Modifier.fillMaxSize()) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                if (error != null) {
                    Text(
                        text = error ?: "",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(currentMessages) { message ->
                        MessageItem(message = message)
                    }
                }
            }
        }
    }
}

@Composable
fun MessageItem(message: ChatMessage) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(
                text = message.authorName,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.content,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun ChatMoodIndicator(mood: Float) {
    val color = when {
        mood > 0.3f -> MaterialTheme.colorScheme.tertiary
        mood < -0.3f -> MaterialTheme.colorScheme.error
        else -> MaterialTheme.colorScheme.secondary
    }
    
    val icon = when {
        mood > 0.3f -> "😊"
        mood < -0.3f -> "😞"
        else -> "😐"
    }
    
    Surface(
        color = color.copy(alpha = 0.2f),
        shape = CircleShape,
        modifier = Modifier.size(32.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = icon,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun ChatMessagesList(
    messages: List<ChatMessage>,
    listState: LazyListState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        state = listState,
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        reverseLayout = true
    ) {
        items(
            items = messages.asReversed(),
            key = { it.id }
        ) { message ->
            ChatMessageItem(message = message)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ChatMessageItem(
    message: ChatMessage,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when(message.messageType) {
        MessageType.QUESTION -> MaterialTheme.colorScheme.primaryContainer
        MessageType.GRATITUDE -> MaterialTheme.colorScheme.secondaryContainer
        MessageType.NEGATIVE -> MaterialTheme.colorScheme.errorContainer
        MessageType.PERSONAL_QUESTION -> MaterialTheme.colorScheme.tertiaryContainer
        else -> MaterialTheme.colorScheme.surfaceVariant
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = message.authorName,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = message.content,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun ErrorMessage(
    error: String,
    streamUrl: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = "Помилка",
            tint = MaterialTheme.colorScheme.error,
            modifier = Modifier.size(48.dp)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Помилка підключення до чату",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.error
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = error,
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.error
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "URL трансляції: $streamUrl",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        ) {
            Text("Спробувати знову")
        }
    }
} 