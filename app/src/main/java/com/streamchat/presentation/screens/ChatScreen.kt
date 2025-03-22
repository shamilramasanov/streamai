package com.streamchat.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
    viewModel: ChatViewModel = hiltViewModel()
) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Всі", "Питання", "Подяки", "Негатив", "Особисті")
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    var error by remember { mutableStateOf<String?>(null) }
    
    val allMessages by viewModel.allMessages.collectAsState(initial = emptyList())
    val questions by viewModel.questions.collectAsState(initial = emptyList())
    val gratitude by viewModel.gratitude.collectAsState(initial = emptyList())
    val negative by viewModel.negative.collectAsState(initial = emptyList())
    val personalQuestions by viewModel.personalQuestions.collectAsState(initial = emptyList())
    val chatMood by viewModel.chatMood.collectAsState(initial = 0.0f)
    val isLoading by viewModel.isLoading.collectAsState(initial = false)
    
    LaunchedEffect(streamUrl) {
        Log.v("StreamChat", "🎬 ChatScreen: LaunchedEffect з URL: '$streamUrl'")
        if (streamUrl.isNotBlank()) {
            try {
                Log.v("StreamChat", "🔄 Спроба підключення до чату з URL: '$streamUrl'")
                viewModel.connectToChat(streamUrl.trim())
                Log.v("StreamChat", "✅ Успішно підключено до чату")
            } catch (e: Exception) {
                Log.e("StreamChat", "❌ Помилка підключення до чату: ${e.message}", e)
                error = e.message
            }
        } else {
            Log.v("StreamChat", "⚠️ URL є порожнім")
        }
    }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = { 
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Чат трансляції")
                            Spacer(modifier = Modifier.width(8.dp))
                            ChatMoodIndicator(chatMood)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                )
                ScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    edgePadding = 0.dp
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { 
                                selectedTab = index
                                scope.launch {
                                    listState.scrollToItem(0)
                                }
                            },
                            text = { 
                                Text(
                                    text = when(index) {
                                        1 -> "$title (${questions.size})"
                                        2 -> "$title (${gratitude.size})"
                                        3 -> "$title (${negative.size})"
                                        4 -> "$title (${personalQuestions.size})"
                                        else -> title
                                    }
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                error != null -> {
                    ErrorMessage(
                        error = error!!,
                        streamUrl = streamUrl,
                        onRetry = {
                            scope.launch {
                                error = null
                                try {
                                    viewModel.connectToChat(streamUrl.trim())
                                } catch (e: Exception) {
                                    error = e.message
                                }
                            }
                        }
                    )
                }
                else -> {
                    val messages = when (selectedTab) {
                        0 -> allMessages
                        1 -> questions
                        2 -> gratitude
                        3 -> negative
                        4 -> personalQuestions
                        else -> emptyList()
                    }
                    ChatMessagesList(
                        messages = messages,
                        listState = listState
                    )
                }
            }
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