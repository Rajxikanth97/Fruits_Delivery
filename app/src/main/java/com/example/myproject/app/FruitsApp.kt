package com.example.myproject.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myproject.data.home.HomeViewModel
import com.example.myproject.navigation.AppRouter
import com.example.myproject.navigation.Screen
import com.example.myproject.screens.HomeScreen
import com.example.myproject.screens.LoginScreen
import com.example.myproject.screens.SignUpScreen
import com.example.myproject.screens.TermsAndConditionsScreen


@Composable
fun FruitsApp(homeViewModel: HomeViewModel = viewModel()) {

    homeViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray
    ) {

        if (homeViewModel.isUserLoggedIn.value == true) {
            AppRouter.navigateTo(Screen.HomeScreen)
        }

        Crossfade(targetState = AppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }

                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }
            }
        }

    }
}