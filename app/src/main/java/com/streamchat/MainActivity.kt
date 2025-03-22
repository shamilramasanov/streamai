package com.streamchat

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.streamchat.data.remote.YouTubeApiService
import com.streamchat.presentation.screens.ChatScreen
import com.streamchat.ui.theme.StreamChatTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    @Inject
    lateinit var youTubeApiService: YouTubeApiService
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.v("StreamChat", "🚀 MainActivity.onCreate()")
        
        setContent {
            StreamChatTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    var streamUrl by remember { mutableStateOf("") }
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = "input") {
        composable("input") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = streamUrl,
                    onValueChange = { 
                        streamUrl = it
                        Log.v("StreamChat", "🔤 Введено URL: $streamUrl")
                    },
                    label = { Text("URL трансляції") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    )
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = {
                        Log.v("StreamChat", "🔘 Натиснуто кнопку з URL: $streamUrl")
                        if (streamUrl.isNotBlank()) {
                            val encodedUrl = Uri.encode(streamUrl)
                            navController.navigate("chat/$encodedUrl")
                        } else {
                            Log.v("StreamChat", "❌ Порожній URL")
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Підключитися до чату")
                }
            }
        }
        
        composable(
            route = "chat/{streamUrl}",
            arguments = listOf(
                navArgument("streamUrl") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) { backStackEntry ->
            val encodedUrl = backStackEntry.arguments?.getString("streamUrl") ?: ""
            val url = Uri.decode(encodedUrl)
            ChatScreen(streamUrl = url)
        }
    }
} 