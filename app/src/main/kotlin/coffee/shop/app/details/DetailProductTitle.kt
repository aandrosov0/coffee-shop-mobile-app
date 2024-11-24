package coffee.shop.app.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.themes.AppTheme

@Composable
fun DetailProductTitle(
    title: String,
    type: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = type,
            modifier = Modifier
                .alpha(.64f)
                .padding(top = 4.dp),
            style = MaterialTheme.typography.titleSmall,
        )
    }
}

@Preview
@Composable
private fun DetailProductTitlePreview() = AppTheme {
    DetailProductTitle(
        title = "Caffee Mocha",
        type = "Ice/Hot"
    )
}