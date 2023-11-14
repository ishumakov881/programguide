package eu.wewox.programguide.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

/**
 * Main activity for demo application.
 * Contains simple "Crossfade" based navigation to various examples.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            var example by rememberSaveable { mutableStateOf<Example?>(null) }
            BackHandler(enabled = example != null) {
                example = null
            }
            App(
                example = example,
                onChangeExample = { example = it },
            )
        }
    }
}
