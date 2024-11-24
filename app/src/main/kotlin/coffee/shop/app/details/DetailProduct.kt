package coffee.shop.app.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.R
import coffee.shop.app.states.CoffeeSize
import coffee.shop.app.themes.AppTheme

@Composable
fun DetailProduct(
    title: String,
    type: String,
    rating: Float,
    reviews: Long,
    description: String,
    size: CoffeeSize,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.coffee_detail1),
            contentDescription = stringResource(R.string.coffee_image),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
                .clip(RoundedCornerShape(8.dp))
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.FillWidth
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            DetailProductTitle(
                title = title,
                type = type
            )
            DetailProductRating(
                rating = rating,
                reviews = reviews,
            )
        }
        HorizontalDivider(
            modifier = Modifier
                .padding(horizontal = 40.dp, vertical = 16.dp),
            thickness = 1.dp
        )
        DetailProductDescription(
            description = description
        )
    }
}

@Preview
@Composable
private fun DetailProductPreview() = AppTheme {
    DetailProduct(
        title = "Caffee Mocha",
        type = "Ice/Hot",
        rating = 4.8f,
        reviews = 230,
        description = stringResource(R.string.detail_product_description),
        size = CoffeeSize.M
    )
}