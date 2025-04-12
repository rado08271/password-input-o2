package sk.o2.android.figura.rado.assignement.password.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TextInputView(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    required: Boolean = false,
    description: String? = null,
    error: Error? = null,
    modifier: Modifier = Modifier,
) {
    InputView(
        label = label,
        value = value,
        onValueChange = onValueChange,
        placeholder = placeholder,
        required = required,
        isError = error != null,
        description = description,
        visualTransformation = VisualTransformation.None,
        modifier = modifier,
    )
}