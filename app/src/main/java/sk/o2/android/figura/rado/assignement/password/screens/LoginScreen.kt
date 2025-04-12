package sk.o2.android.figura.rado.assignement.password.screens

import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import sk.o2.android.figura.rado.assignement.password.components.InputView
import sk.o2.android.figura.rado.assignement.password.components.PasswordInputView
import sk.o2.android.figura.rado.assignement.password.components.TextInputView
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorContentOnNeutralMedium
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorSurfaceBrand
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorSurfaceDanger
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorSurfaceDangerVariant
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorSurfaceXLow
import sk.o2.android.figura.rado.assignement.password.ui.theme.O2Blue500
import sk.o2.android.figura.rado.assignement.password.util.emailValidator
import kotlin.time.Duration

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailError by remember { mutableStateOf<Error?>(Error("No email provided")) }
    var passwordError by remember { mutableStateOf<Error?>(Error("No password provided")) }

    var localContext = LocalContext.current

    fun onEmailChange(emailInput: String) {
        try {
            emailValidator(emailInput)
            emailError = null
        } catch (e: Error) {
            emailError = e
        } finally {
            email = emailInput
        }
    }

    fun onPasswordChange(passwordInput: String) {
        password = passwordInput
    }

    fun onWrongPassword(passwordErrorInput: Error?) {
        passwordError = passwordErrorInput ?: null
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextInputView(
            label = "Email",
            value = email,
            onValueChange = { onEmailChange(it) },
            placeholder = "e.g. email@domain.com",
            required = true,
            error = emailError,
        )
        PasswordInputView(
            label = "Password",
            value = password,
            onValueChange = { onPasswordChange(it) },
            placeholder = "e.g. email@domain.com",
            required = true,
            error = passwordError,
            description = "Your password must be at least 8 chars long and include at least 1 number, 1 special character and 1 uppercase character",
            onWrongPassword = { onWrongPassword(it) },
        )
        Column(
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            if (emailError != null) {
                Text(
                    emailError!!.message ?: "",
                    color = ColorSurfaceDanger,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            if (passwordError != null) {
                Text(
                    passwordError!!.message ?: "",
                    color = ColorSurfaceDanger,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
        Box(
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = passwordError == null && emailError == null,
                colors = ButtonColors(
                    containerColor = ColorSurfaceBrand,
                    contentColor = ColorSurfaceXLow,
                    disabledContainerColor = ColorSurfaceXLow,
                    disabledContentColor = ColorSurfaceXLow
                ),
                onClick = {
                    Toast.makeText(localContext, "You have signed up!", Toast.LENGTH_SHORT).show()
                },
                content = {
                    Text(
                        "Signup",
                        color = if (passwordError == null && emailError == null) ColorSurfaceXLow else ColorSurfaceDangerVariant,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            )
        }

    }
}