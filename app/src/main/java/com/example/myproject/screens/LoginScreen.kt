package com.example.myproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myproject.R
import com.example.myproject.components.ButtonComponent
import com.example.myproject.components.ClickableLoginTextComponent
import com.example.myproject.components.DividerTextComponent
import com.example.myproject.components.HeadingTextComponent
import com.example.myproject.components.MyTextFieldComponent
import com.example.myproject.components.PasswordTextFieldComponent
import com.example.myproject.data.LoginViewModel
import com.example.myproject.data.login.LoginUIEvent
import com.example.myproject.navigation.AppRouter
import com.example.myproject.navigation.Screen
import com.example.myproject.navigation.SystemBackButtonHandler


@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
        ) {

            Column( modifier = Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier.size(350.dp),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null)
                Spacer(modifier = Modifier.height(0.dp))
                HeadingTextComponent(value = "Login")
                Spacer(modifier = Modifier.height(20.dp))

                MyTextFieldComponent(labelValue = stringResource(id = com.example.myproject.R.string.email),
                    painterResource(id = com.example.myproject.R.drawable.message),
                    onTextChanged = { loginViewModel.onEvent(LoginUIEvent.EmailChanged(it)) },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id =com.example.myproject. R.string.password),
                    painterResource(id = com.example.myproject.R.drawable.lock),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )

                Spacer(modifier = Modifier.height(40.dp))

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(
                    value = stringResource(id = com.example.myproject.R.string.login),
                    onButtonClicked = {
                       loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = loginViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    AppRouter.navigateTo(Screen.SignUpScreen)
                })
            }
        }

        if(loginViewModel.loginInProgress.value) {
            CircularProgressIndicator()
        }
    }

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignUpScreen)
    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}

