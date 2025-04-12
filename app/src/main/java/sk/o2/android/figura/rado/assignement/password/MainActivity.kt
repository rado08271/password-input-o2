package sk.o2.android.figura.rado.assignement.password

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sk.o2.android.figura.rado.assignement.password.screens.LoginScreen
import sk.o2.android.figura.rado.assignement.password.ui.theme.PasswordInputAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PasswordInputAppTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) { innerPadding ->
                    LoginScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PasswordInputAppTheme {
        LoginScreen()
    }
}