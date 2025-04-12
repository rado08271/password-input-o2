package sk.o2.android.figura.rado.assignement.password.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import sk.o2.android.figura.rado.assignement.password.util.PasswordLengthError
import sk.o2.android.figura.rado.assignement.password.util.passwordValidator

@Composable
fun PasswordInputView(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    required: Boolean = false,
    description: String? = null,
    error: Error? = null,
    onWrongPassword: ((Error?) -> Unit)? = null,
    modifier: Modifier = Modifier,
) {
    var isHidden by remember { mutableStateOf(true) }

    fun onPasswordTyped(password: String) {
        try {
            passwordValidator(password)

            if (onWrongPassword != null) {
                onWrongPassword(null)
            }
        } catch (e: Error) {
            if (onWrongPassword != null) {
                onWrongPassword(e)
            }
        } finally {
            onValueChange(password)
        }
    }

    InputView(
        label = label,
        value = value,
        onValueChange = { onPasswordTyped(it) },
        placeholder = placeholder,
        required = required,
        isError = error != null,
        description = description,
        visualTransformation = if (isHidden) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = modifier,
        trailingIcon = if (isHidden) Icons.Outlined.Lock else Icons.Filled.Lock,
        onTrailingIconClicked = { isHidden = !isHidden}
    )

}