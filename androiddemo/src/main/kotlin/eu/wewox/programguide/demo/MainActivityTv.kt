package eu.wewox.programguide.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.Text
import androidx.tv.material3.MaterialTheme

class MainActivityTv : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // Your TV-specific UI goes here
                Text(text = "Hello Android TV!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewTv() {
    MaterialTheme {
        Text(text = "Hello Android TV!")
    }
}
