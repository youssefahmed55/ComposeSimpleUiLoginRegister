package com.example.simpleui_login_register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleui_login_register.ui.theme.SimpleUiLoginRegisterTheme
import com.example.simpleui_login_register.ui.view.LoginPage
import com.example.simpleui_login_register.ui.view.RegisterPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleUiLoginRegisterTheme {
                NavigatePage()
            }
        }
    }
}

@Composable
fun NavigatePage() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = "login_page", builder = {
            composable("login_page", content = { LoginPage(navController = navController) })
            composable("register_page", content = { RegisterPage(navController = navController) })
        }
    )

}

@Preview(showBackground = true, device = "id:Nexus 5X")
@Composable
fun SimpleUiLoginRegisterPreview() {
    SimpleUiLoginRegisterTheme {
        LoginPage()
    }
}


