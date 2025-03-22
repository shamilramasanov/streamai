package com.streamchat.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.streamchat.presentation.viewmodels.StreamInputViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StreamInputScreen(
    onNavigateToChat: (String) -> Unit,
    viewModel: StreamInputViewModel = hiltViewModel()
) {
    var streamUrl by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "StreamChat",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = streamUrl,
            onValueChange = { 
                streamUrl = it
                isError = false
                Log.v("StreamChat", "🔤 Введено URL: $it")
            },
            label = { Text("Введіть URL трансляції YouTube") },
            modifier = Modifier.fillMaxWidth(),
            isError = isError,
            supportingText = if (isError) {
                { Text("Будь ласка, введіть коректний URL YouTube") }
            } else null,
            singleLine = true
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = {
                Log.v("StreamChat", "🔘 Натиснуто кнопку з URL: $streamUrl")
                if (streamUrl.contains("youtube.com/watch?v=") || 
                    streamUrl.contains("youtu.be/")
                ) {
                    onNavigateToChat(streamUrl)
                } else {
                    isError = true
                    Log.v("StreamChat", "❌ Порожній URL")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Підключитися до трансляції")
        }

        Spacer(modifier = Modifier.height(32.dp))
        
        Text(
            text = "Введіть URL трансляції YouTube для підключення до чату.\n" +
                  "Наприклад: https://youtube.com/watch?v=...",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
} 