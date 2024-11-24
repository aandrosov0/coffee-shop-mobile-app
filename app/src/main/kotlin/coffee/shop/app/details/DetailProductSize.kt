package coffee.shop.app.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.Choice
import coffee.shop.app.R
import coffee.shop.app.states.CoffeeSize
import coffee.shop.app.themes.AppTheme

@Composable
fun DetailProductSize(
    current: CoffeeSize,
    onSizeChange: (CoffeeSize) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.size),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        Row(
            modifier = Modifier
                .padding(top = 16.dp)
                .selectableGroup()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CoffeeSize.entries.forEach { size ->
                Choice(
                    text = size.name,
                    selected = size == current,
                    onClick = { onSizeChange(size) }
                )
            }
        }
    }
}

@Preview
@Composable
private fun DetailProductSizePreview() = AppTheme {
    DetailProductSize(
        current = CoffeeSize.M,
        onSizeChange = {}
    )
}