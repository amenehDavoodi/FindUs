package com.example.bookingmeetingroom.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import com.example.bookingmeetingroom.R
import com.example.bookingmeetingroom.ui.theme.BookingMeetingRoomTheme
import com.example.bookingmeetingroom.utils.supportWideScreen


sealed class LoginEvent {
    data class SignIn(val username: String, val password: String) : LoginEvent()
    object SignUp : LoginEvent()
    object NavigateBack : LoginEvent()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SignIn(onNavigationEvent: (LoginEvent) -> Unit) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val snackbarErrorText = stringResource(id = R.string.feature_not_available)
    val snackbarActionLabel = stringResource(id = R.string.dismiss)

    Scaffold(
        topBar = {
            SignInSignUpTopAppBar(
                topAppBarText = stringResource(id = R.string.sign_in),
                onBackPressed = { onNavigationEvent(LoginEvent.NavigateBack) }
            )
        },
        content = {
            SignInSignUpScreen(
                modifier = Modifier.supportWideScreen(),
//                onSignedInAsGuest = { onNavigationEvent(LoginEvent.SignInAsGuest) }
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    SignInContent(
                        onSignInSubmitted = { email, password ->
                            onNavigationEvent(LoginEvent.SignIn(email, password))
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextButton(
                        onClick = {
                            scope.launch {
                                snackbarHostState.showSnackbar(
                                    message = snackbarErrorText,
                                    actionLabel = snackbarActionLabel
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = stringResource(id = R.string.forgot_password))
                    }
                }
            }
        }
    )

    Box(modifier = Modifier.fillMaxSize()) {
        ErrorSnackbar(
            snackbarHostState = snackbarHostState,
            onDismiss = { snackbarHostState.currentSnackbarData?.dismiss() },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ErrorSnackbar(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = { }
) {

        SnackbarHost(
            hostState = snackbarHostState,
            snackbar = { data ->
                Snackbar(
                    modifier = Modifier.padding(16.dp),
                    content = {
                        Text(
                            text = data.message,
                            style = MaterialTheme.typography.body2
                        )
                    },
                    action = {
                        data.actionLabel?.let {
                            TextButton(onClick = onDismiss) {
                                Text(
                                    text = stringResource(id = R.string.dismiss),
                                color = MaterialTheme.colors.error
                                )
                            }
                        }
                    }
                )
            },
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(Alignment.Bottom)

        )

}

@Composable
fun SignInContent(
    onSignInSubmitted: (userName: String, password: String) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val focusRequester = remember { FocusRequester() }
        val userNameState = remember { UserNameState() }
        UserName(userNameState, onImeAction = { focusRequester.requestFocus() })

        Spacer(modifier = Modifier.height(16.dp))
        val passwordState = remember { PasswordState() }
        Password(
            label = stringResource(id = R.string.password),
            passwordState = passwordState,
            modifier = Modifier.focusRequester(focusRequester),
            onImeAction = { onSignInSubmitted(userNameState.text, passwordState.text) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onSignInSubmitted(userNameState.text, passwordState.text) },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(vertical = 16.dp),
            enabled = userNameState.isValid && passwordState.isValid
        ) {
            Text(
                text = stringResource(id = R.string.sign_in)
            )
        }
    }

}

@Preview(name = "Sign in light theme")
@Composable
fun SignInPreview() {
    BookingMeetingRoomTheme {
        SignIn {}
    }
}

@Preview(name = "Sign in dark theme")
@Composable
fun SignInPreviewDark() {
    BookingMeetingRoomTheme(darkTheme = true) {
        SignIn {}
    }
}
