package com.streamchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.streamchat.presentation.screens.ChatScreen
import com.streamchat.presentation.screens.MainScreen
import com.streamchat.presentation.theme.StreamChatTheme
import com.streamchat.presentation.viewmodels.ChatViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import android.util.Log

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAppContent()
        }
    }
}

@Composable
fun MainAppContent() {
    StreamChatTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()
            
            NavHost(
                navController = navController,
                startDestination = "main"
            ) {
                composable("main") {
                    MainScreen(
                        onNavigateToChat = { streamUrl ->
                            val encodedUrl = java.net.URLEncoder.encode(streamUrl, "UTF-8")
                            navController.navigate("chat/$encodedUrl")
                        }
                    )
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
                    val streamUrl = backStackEntry.arguments?.getString("streamUrl")?.let {
                        java.net.URLDecoder.decode(it, "UTF-8")
                    } ?: return@composable
                    
                    val chatViewModel: ChatViewModel = hiltViewModel()
                    ChatScreen(
                        streamUrl = streamUrl,
                        viewModel = chatViewModel,
                        onNavigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
            }
        }
    }
} 