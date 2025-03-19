package com.merteroglu286.kotlinogreniyorum.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.merteroglu286.kotlinogreniyorum.navigation.SetupNavGraph
import com.merteroglu286.kotlinogreniyorum.presentation.screen.splash.SplashScreen
import com.merteroglu286.kotlinogreniyorum.ui.theme.KotlinOgreniyorumTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinOgreniyorumTheme {
                navHostController = rememberNavController()
                SetupNavGraph(navHostController = navHostController)

            }
        }
    }
}