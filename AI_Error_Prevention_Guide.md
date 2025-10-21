# Руководство по использованию Surface в Jetpack Compose TV

При использовании `androidx.tv.material3.Surface` с параметром `onClick` необходимо учитывать следующие особенности:

1.  **Цвета (colors)**: Используйте `androidx.tv.material3.ClickableSurfaceDefaults.colors()` вместо `androidx.tv.material3.SurfaceDefaults.colors()`.
    *   `SurfaceDefaults.colors()` возвращает `SurfaceColors`.
    *   `ClickableSurfaceDefaults.colors()` возвращает `ClickableSurfaceColors`, что требуется для кликабельных поверхностей.

2.  **Границы (border)**: Используйте `androidx.tv.material3.ClickableSurfaceDefaults.border()` вместо `androidx.tv.material3.Border()`.
    *   `Border()` возвращает `Border`.
    *   `ClickableSurfaceDefaults.border()` возвращает `ClickableSurfaceBorder`, что требуется для кликабельных поверхностей.

**Пример:**

```kotlin
Surface(
    colors = ClickableSurfaceDefaults.colors(
        containerColor = MaterialTheme.colorScheme.primary,
        focusedContainerColor = MaterialTheme.colorScheme.secondary
    ),
    border = ClickableSurfaceDefaults.border(
        BorderStroke(1.dp, MaterialTheme.colorScheme.surface),
        focusedBorder = BorderStroke(2.dp, Color.White)
    ),
    onClick = { /* ... */ },
    modifier = Modifier.focusable()
) {
    // ... Content ...
}
```