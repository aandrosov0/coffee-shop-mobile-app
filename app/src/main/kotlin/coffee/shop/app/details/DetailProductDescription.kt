package coffee.shop.app.details

import android.util.Range
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.R
import coffee.shop.app.themes.AppTheme

@Composable
fun DetailProductDescription(
    description: String,
    modifier: Modifier = Modifier,
    rolledRange: IntRange = 0..120
) {
    var expanded by remember { mutableStateOf(false) }
    val expandableDescription = if (rolledRange.last < description.length && !expanded) {
        description.slice(rolledRange).trim() + "..."
    } else {
        expanded = true
        description
    }

    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.description),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = buildAnnotatedString {
                append(expandableDescription)
                if (!expanded) {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        append(stringResource(R.string.read_more))
                    }
                }
            },
            modifier = Modifier
                .alpha(.64f)
                .padding(top = 8.dp)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = ripple(bounded = false, color = MaterialTheme.colorScheme.primary),
                    onClick = { expanded = !expanded }
                ),
            textAlign = TextAlign.Justify,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
private fun DetailProductDescriptionPreview() = AppTheme {
    DetailProductDescription(
        description = stringResource(R.string.detail_product_description)
    )
}