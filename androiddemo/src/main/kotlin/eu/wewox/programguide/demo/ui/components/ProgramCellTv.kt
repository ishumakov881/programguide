package eu.wewox.programguide.demo.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.ClickableSurfaceDefaults
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import eu.wewox.programguide.demo.data.Program
import eu.wewox.programguide.demo.data.formatTime

val JetStreamCardShape = ShapeDefaults.ExtraSmall
val JetStreamBorderWidth = 3.dp

/**
 * Single program cell in program guide for Android TV.
 *
 * @param program The program data.
 * @param modifier The modifier instance for the root composable.
 * @param onClick Callback to be called when the surface is clicked.
 */
@Composable
fun ProgramCellTv(program: Program, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {

    val context = LocalContext.current

    Surface(
        colors = ClickableSurfaceDefaults.colors(
            containerColor = Color(0xFF1a237e), // programguide_default_schedule_color
           focusedContainerColor = Color(0xFF1565c0) // programguide_selected_schedule_color
        ),
//        border = androidx.tv.material3.ClickableSurfaceDefaults.border(
//            border = Border(BorderStroke(1.dp, MaterialTheme.colorScheme.surface)),
//            focusedBorder = Border(BorderStroke(2.dp, Color.White)) // White border on focus
//        ),

        shape = ClickableSurfaceDefaults.shape(JetStreamCardShape),
        border = ClickableSurfaceDefaults.border(
            focusedBorder = Border(
                border = BorderStroke(
                    width = JetStreamBorderWidth,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                shape = JetStreamCardShape
            ),
            border = Border(
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.border),
                shape = RoundedCornerShape(8.dp)
            )
        ),
        scale = ClickableSurfaceDefaults.scale(focusedScale = 2.5f),

        onClick = onClick ?: { },
        enabled = onClick != null,
        modifier = modifier.onFocusChanged{
            if(it.isFocused){
                Toast.makeText(context, "@@@@@", Toast.LENGTH_SHORT).show()
            }
        }.graphicsLayer(clip = false),
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = program.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.Red
            )
            Text(
                text = formatTime(program.start, program.end),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant // Используем вариант цвета
            )
        }
    }
}
