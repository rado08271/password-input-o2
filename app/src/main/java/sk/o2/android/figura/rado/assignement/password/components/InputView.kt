package sk.o2.android.figura.rado.assignement.password.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorContentOnNeutralLow
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorContentOnNeutralXXHigh
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorSurfaceDanger
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorSurfaceXHigh
import sk.o2.android.figura.rado.assignement.password.ui.theme.ColorSurfaceXLow
import sk.o2.android.figura.rado.assignement.password.ui.theme.Dimension2Xs
import sk.o2.android.figura.rado.assignement.password.ui.theme.DimensionRadiusInput
import sk.o2.android.figura.rado.assignement.password.ui.theme.DimensionXs
import sk.o2.android.figura.rado.assignement.password.ui.theme.O2Blue500
import java.lang.Error

@Composable
fun InputView(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    required: Boolean = false,
    isError: Boolean = false,
    description: String? = null,
    trailingIcon: ImageVector? = null,
    onTrailingIconClicked: (() -> Unit)? = null,
    visualTransformation: VisualTransformation? = VisualTransformation.None,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(DimensionXs)
    ) {
        Column {
            // label
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(DimensionXs)
            ) {
                Text(
                    label,
                    style = MaterialTheme.typography.labelMedium,
                    color = if (isError) ColorSurfaceDanger else ColorContentOnNeutralXXHigh
                )
                if (!required) {
                    // required
                    Text(
                        text = "Optional",
                        style = MaterialTheme.typography.labelSmall,
                        color = ColorContentOnNeutralLow
                    )
                }
            }
            // description
            if (!description.isNullOrEmpty()) {
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(Dimension2Xs)
                ) {
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodySmall,
                        color = ColorContentOnNeutralXXHigh
                    )
                }
            }
        }
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(DimensionRadiusInput),
            isError = isError,
            visualTransformation = visualTransformation!!,
            colors = OutlinedTextFieldDefaults.colors(
                errorBorderColor = ColorSurfaceDanger,
                errorTrailingIconColor = ColorSurfaceXHigh,

                unfocusedPlaceholderColor = ColorContentOnNeutralLow,
                unfocusedBorderColor = ColorSurfaceXHigh,

                focusedBorderColor = O2Blue500,
                focusedPlaceholderColor = O2Blue500,
                cursorColor = O2Blue500,

                unfocusedContainerColor = ColorSurfaceXLow,
                focusedContainerColor = ColorSurfaceXLow,
                disabledContainerColor = ColorSurfaceXLow,
                errorContainerColor = ColorSurfaceXLow,

                ),
            singleLine = true,
            placeholder = { Text( placeholder ) },
            trailingIcon = {
                if (trailingIcon != null) {
                    IconButton(onClick = { if (onTrailingIconClicked != null) onTrailingIconClicked() }) {
                        Icon(trailingIcon, "trailing icon")
                    }

                }
            })
        // error text

    }
}