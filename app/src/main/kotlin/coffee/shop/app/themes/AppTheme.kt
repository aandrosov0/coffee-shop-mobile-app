package coffee.shop.app.themes

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colorSchemeLight = MaterialTheme.colorScheme.copy(
        primary = primaryLightColor,
        background = backgroundLightColor,
        surface = surfaceLightColor,
        tertiaryContainer = tertiaryContainerLightColor,
        onTertiaryContainer = onTertiaryContainerLightColor
    )

    val typography = MaterialTheme.typography.copy(
        displayLarge = MaterialTheme.typography.displayLarge.copy(fontFamily = soraFontFamily),
        displayMedium = MaterialTheme.typography.displayMedium.copy(fontFamily = soraFontFamily),
        displaySmall = MaterialTheme.typography.displaySmall.copy(fontFamily = soraFontFamily),
        headlineLarge = MaterialTheme.typography.headlineLarge.copy(fontFamily = soraFontFamily),
        headlineMedium = MaterialTheme.typography.headlineMedium.copy(fontFamily = soraFontFamily),
        headlineSmall = MaterialTheme.typography.headlineSmall.copy(fontFamily = soraFontFamily),
        titleLarge = MaterialTheme.typography.titleLarge.copy(fontFamily = soraFontFamily),
        titleMedium = MaterialTheme.typography.titleMedium.copy(fontFamily = soraFontFamily),
        titleSmall = MaterialTheme.typography.titleSmall.copy(fontFamily = soraFontFamily),
        bodyLarge = MaterialTheme.typography.bodyLarge.copy(fontFamily = soraFontFamily),
        bodyMedium = MaterialTheme.typography.bodyMedium.copy(fontFamily = soraFontFamily),
        bodySmall = MaterialTheme.typography.bodySmall.copy(fontFamily = soraFontFamily),
        labelLarge = MaterialTheme.typography.labelLarge.copy(fontFamily = soraFontFamily),
        labelMedium = MaterialTheme.typography.labelMedium.copy(fontFamily = soraFontFamily),
        labelSmall = MaterialTheme.typography.labelSmall.copy(fontFamily = soraFontFamily)
    )

    MaterialTheme(
        colorScheme = colorSchemeLight,
        typography = typography,
        content = content,
    )
}