package coffee.shop.app.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.R
import coffee.shop.app.themes.AppTheme

@Composable
fun DetailBottomAppBar(
    price: Float,
    onBuy: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ).fillMaxWidth()
            .padding(
                start = 24.dp, end = 24.dp,
                top = 20.dp, bottom = 50.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = stringResource(R.string.price),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.alpha(.64f)
            )
            Text(
                text = "$ $price",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        }
        Button(
            onClick = onBuy,
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(horizontal = 72.dp, vertical = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.buy_now),
            )
        }
    }
}

@Preview
@Composable
private fun DetailBottomAppBarPreview() = AppTheme {
    DetailBottomAppBar(
        price = 0.0f,
        onBuy = {}
    )
}