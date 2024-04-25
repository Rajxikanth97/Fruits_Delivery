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
import com.example.myproject.components.ButtonComponent
import com.example.myproject.components.CheckboxComponent
import com.example.myproject.components.ClickableLoginTextComponent
import com.example.myproject.components.DividerTextComponent
import com.example.myproject.components.HeadingTextComponent
import com.example.myproject.components.MyTextFieldComponent
import com.example.myproject.components.PasswordTextFieldComponent
import com.example.myproject.data.signup.SignupUIEvent
import com.example.myproject.data.signup.SignupViewModel
import com.example.myproject.navigation.AppRouter
import com.example.myproject.navigation.Screen


@Composable
fun SignUpScreen(signupViewModel: SignupViewModel = viewModel()) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center,

    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(28.dp)
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Image(
                    modifier = Modifier.size(220.dp),
                    painter = painterResource(id = com.example.myproject.R.drawable.logo),
                    contentDescription = null)
                  HeadingTextComponent(value = "Fruits App")
                  Spacer(modifier = Modifier.height(8.dp))
                  MyTextFieldComponent(
                    labelValue = stringResource(id = com.example.myproject.R.string.first_name),
                    painterResource(id =com.example.myproject. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.FirstNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.firstNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id = com.example.myproject.R.string.last_name),
                    painterResource = painterResource(id =com.example.myproject. R.drawable.profile),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.LastNameChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.lastNameError
                )

                MyTextFieldComponent(
                    labelValue = stringResource(id =com.example.myproject. R.string.email),
                    painterResource = painterResource(id = com.example.myproject.R.drawable.message),
                    onTextChanged = {
                        signupViewModel.onEvent(SignupUIEvent.EmailChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.emailError
                )

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = com.example.myproject.R.string.password),
                    painterResource = painterResource(id = com.example.myproject.R.drawable.ic_lock),
                    onTextSelected = {
                        signupViewModel.onEvent(SignupUIEvent.PasswordChanged(it))
                    },
                    errorStatus = signupViewModel.registrationUIState.value.passwordError
                )

                CheckboxComponent(value = stringResource(id = com.example.myproject.R.string.terms_and_conditions),
                    onTextSelected = {
                        AppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    },
                    onCheckedChange = {
                        signupViewModel.onEvent(SignupUIEvent.PrivacyPolicyCheckBoxClicked(it))
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))

                ButtonComponent(
                    value = stringResource(id =com.example.myproject. R.string.register),
                    onButtonClicked = {
                        signupViewModel.onEvent(SignupUIEvent.RegisterButtonClicked)
                    },
                    isEnabled = signupViewModel.allValidationsPassed.value
                )

                Spacer(modifier = Modifier.height(10.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                    AppRouter.navigateTo(Screen.LoginScreen)
                })
            }
        }


        if(signupViewModel.signUpInProgress.value) {
            CircularProgressIndicator()
        }
    }

}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}