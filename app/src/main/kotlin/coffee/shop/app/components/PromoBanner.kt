package coffee.shop.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.R
import coffee.shop.app.themes.AppTheme

@Composable
fun PromoBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
            .paint(
                painter = painterResource(R.drawable.banner_1),
                contentScale = ContentScale.FillBounds
            )
            .padding(horizontal = 24.dp, vertical = 13.dp)
            .size(327.dp, 140.dp),
    ) {
        Text(
            text = stringResource(R.string.promo),
            modifier = Modifier
                .background(
                    color = Color(0XFFED5151),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 6.dp, vertical = 4.dp),
            color = Color.White,
            style = MaterialTheme.typography.labelLarge,
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
        ) {
            stringResource(R.string.promo_text).split("\n").forEach { text ->
                Text(
                    text = text,
                    modifier = Modifier
                        .drawBehind {
                            drawRect(
                                brush = Brush.verticalGradient(
                                    listOf(Color(0xff111111), Color(0xff313131))
                                ),
                                topLeft = Offset(-5f, 30f),
                                size = this.size.copy(width = this.size.width + 25, this.size.height - 20)
                            )
                        },
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displaySmall
                )
            }
        }
    }
}

@Preview
@Composable
private fun PromoBannerPreview() = AppTheme {
    PromoBanner()
}