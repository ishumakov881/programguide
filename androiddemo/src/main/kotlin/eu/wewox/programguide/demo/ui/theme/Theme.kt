package eu.wewox.programguide.demo.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.darkColorScheme
import androidx.tv.material3.lightColorScheme
import androidx.tv.material3.Shapes
import androidx.tv.material3.Typography

// Define your TV-specific colors
private val TVDarkColorScheme = darkColorScheme(
    primary = Color(0xFF1565c0), // programguide_selected_schedule_color
    onPrimary = Color.White,
    secondary = Color(0xFF0E1561), // programguide_past_schedule_color
    tertiary = Color(0xFF1a237e), // programguide_default_schedule_color
    onTertiary = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = Color.Black,
    onSurface = Color.White,
    error = Color(0xFFB00020),
    onError = Color.White
)

private val TVLightColorScheme = lightColorScheme(
    primary = Color(0xFF1565c0), // programguide_selected_schedule_color
    onPrimary = Color.White,
    secondary = Color(0xFF0E1561), // programguide_past_schedule_color
    tertiary = Color(0xFF1a237e), // programguide_default_schedule_color
    onTertiary = Color.White,
    background = Color.White,
    onBackground = Color.Black,
    surface = Color.White,
    onSurface = Color.Black,
    error = Color(0xFFB00020),
    onError = Color.White
)

// Define your TV-specific typography (can be customized further)
private val TVTypography = Typography()

// Define your TV-specific shapes (can be customized further)
private val TVShapes = Shapes()

@Composable
fun ProgramGuideTvTheme(
    darkTheme: Boolean = true, // Assuming TV apps are mostly dark themed
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) TVDarkColorScheme else TVLightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = TVShapes,
        typography = TVTypography,
        content = content
    )
}
