package eu.wewox.programguide.demo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.ClickableSurfaceDefaults
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import androidx.tv.material3.Text
import eu.wewox.programguide.demo.data.Program
import eu.wewox.programguide.demo.data.formatTime

/**
 * Single program cell in program guide for Android TV.
 *
 * @param program The program data.
 * @param modifier The modifier instance for the root composable.
 * @param onClick Callback to be called when the surface is clicked.
 */
@Composable
fun ProgramCellTv(program: Program, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    Surface(
        colors = ClickableSurfaceDefaults.colors(
            containerColor = MaterialTheme.colorScheme.secondary, // Use theme secondary color
            focusedContainerColor = MaterialTheme.colorScheme.primary // Use theme primary color for focus
        ),
        border = ClickableSurfaceDefaults.border(
            border = Border(BorderStroke(1.dp, MaterialTheme.colorScheme.surface)),
            focusedBorder = Border(BorderStroke(2.dp, Color.White)) // White border on focus
        ),
        scale = ClickableSurfaceDefaults.scale(focusedScale = 1.05f), // Added scale
        onClick = onClick ?: { },
        enabled = onClick != null,
        modifier = modifier,
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                text = program.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = formatTime(program.start, program.end),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelSmall,
            )
        }
    }
}