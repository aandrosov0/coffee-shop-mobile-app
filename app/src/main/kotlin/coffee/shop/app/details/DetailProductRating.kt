package coffee.shop.app.details

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.R
import coffee.shop.app.themes.AppTheme

@Composable
fun DetailProductRating(
    rating: Float,
    reviews: Long,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.rating),
            contentDescription = stringResource(R.string.rating),
            modifier = Modifier.padding(end = 4.dp),
            tint = Color.Unspecified
        )
        Text(
            text = "$rating",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = " ($reviews)",
            modifier = Modifier
                .align(Alignment.Bottom)
                .alpha(.64f),
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview
@Composable
private fun DetailProductRatingPreview() = AppTheme {
    DetailProductRating(
        rating = 4.8f,
        reviews = 230
    )
}