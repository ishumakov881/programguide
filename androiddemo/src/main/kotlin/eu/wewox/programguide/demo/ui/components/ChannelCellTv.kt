package eu.wewox.programguide.demo.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Surface
import androidx.tv.material3.Text

/**
 * Single channel cell in program guide for Android TV.
 *
 * @param index The channel index.
 * @param modifier The modifier instance for the root composable.
 * @param onClick Callback to be called when the surface is clicked.
 */
@Composable
fun ChannelCellTv(index: Int, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    Surface(
        colors = androidx.tv.material3.ClickableSurfaceDefaults.colors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            focusedContainerColor = MaterialTheme.colorScheme.primary // Highlight on focus
        ),
        border = androidx.tv.material3.ClickableSurfaceDefaults.border(
            border = Border(BorderStroke(1.dp, MaterialTheme.colorScheme.surface)),
            focusedBorder = Border(BorderStroke(2.dp, Color.White)) // White border on focus
        ),
        onClick = onClick ?: { },
        enabled = onClick != null,
        modifier = modifier.focusable(), // Make it focusable
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(
                text = "Ch #$index",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(4.dp),
            )
        }
    }
}
