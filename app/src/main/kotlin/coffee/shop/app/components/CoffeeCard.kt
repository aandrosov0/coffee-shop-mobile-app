package coffee.shop.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.R
import coffee.shop.app.themes.AppTheme
import coil3.compose.AsyncImage

@Composable
fun CoffeeCard(
    imageUrl: String,
    title: String,
    type: String,
    price: Float,
    rating: Float,
    modifier: Modifier = Modifier
) { 
    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(8.dp)
            )
            .size(158.dp, 238.dp)
            .padding(8.dp)
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp)),
                placeholder = painterResource(R.drawable.coffee_image_sample1),
                error = painterResource(R.drawable.coffee_image_sample1),
                contentScale = ContentScale.Fit
            )
            Row(
                modifier = Modifier
                    .background(
                        color = Color.Black.copy(.5f),
                        shape = RoundedCornerShape(
                            topEnd = 8.dp,
                            bottomStart = 32.dp
                        )
                    )
                    .padding(horizontal = 14.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(R.drawable.rating),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(12.dp)
                )
                Text(
                    text = "$rating",
                    modifier = Modifier.padding(start = 4.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
        Text(
            text = title,
            modifier = Modifier.padding(top = 8.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = type,
            modifier = Modifier
                .padding(top = 4.dp)
                .alpha(.64f),
            fontWeight = FontWeight.Normal,
            style = MaterialTheme.typography.labelSmall
        )
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$ $price",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelLarge
            )
            Icon(
                painter = painterResource(R.drawable.plus),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(),
                        onClick = {}
                    )
            )
        }
    }
}

@Preview
@Composable
private fun CoffeeCardPreview() = AppTheme {
    CoffeeCard(
        imageUrl = "",
        title = "Caffe Mocha",
        type = "Deep Foam",
        price = 4.53f,
        rating = 4.8f
    )
}