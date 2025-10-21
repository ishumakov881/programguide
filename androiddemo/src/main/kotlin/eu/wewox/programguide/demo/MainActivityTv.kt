package eu.wewox.programguide.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.Text
import androidx.tv.material3.MaterialTheme
import com.lds.cinema.presentation.theme.JetStreamTheme
import eu.wewox.programguide.demo.screens.ProgramGuideSimpleScreenTv

class MainActivityTv : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetStreamTheme(true) {


                Row {
                    //DemoView()
                    ProgramGuideSimpleScreenTv()
                }
            }
        }
    }


}


@Composable
private fun RowScope.DemoView() {
    Button(
        onClick = { },
        shape = ButtonDefaults.shape(
            shape = RoundedCornerShape(8.dp)
        ),
        colors = ButtonDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.15f),
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.surface,
            focusedContentColor = MaterialTheme.colorScheme.onSurface
        ),
        scale = ButtonDefaults.scale(focusedScale = 1.1f),

        ) {
        Text(text = "@@@@@")
    }


    Button(
        onClick = { },
        shape = ButtonDefaults.shape(
            shape = RoundedCornerShape(8.dp)
        ),
        colors = ButtonDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.15f),
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.surface,
            focusedContentColor = MaterialTheme.colorScheme.onSurface
        ),
        scale = ButtonDefaults.scale(focusedScale = 1.1f),

        ) {
        Text(text = "@@@@@")
    }

    Button(
        onClick = { },
        shape = ButtonDefaults.shape(
            shape = RoundedCornerShape(8.dp)
        ),
        colors = ButtonDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.15f),
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.surface,
            focusedContentColor = MaterialTheme.colorScheme.onSurface
        ),
        scale = ButtonDefaults.scale(focusedScale = 1.1f),

        ) {
        Text(text = "@@@@@")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewTv() {
    MaterialTheme {
        Text(text = "Hello Android TV!")
    }
}
