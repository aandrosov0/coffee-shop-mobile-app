package coffee.shop.app.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.R
import coffee.shop.app.Screen
import coffee.shop.app.themes.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopAppBar(
    onNavigateUp: () -> Unit,
    onFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = Screen.Detail.name,
                modifier = Modifier.padding(vertical = 12.5.dp),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
        },
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 24.dp),
        navigationIcon = {
            IconButton(
                onClick = onNavigateUp,
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.arrrow_left),
                    contentDescription = stringResource(R.string.back),
                )
            }
        },
        actions = {
            IconButton(
                onClick = onFavorite,
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.heart),
                    contentDescription = stringResource(R.string.favorite),
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}

@Preview
@Composable
private fun DetailTopAppBarPreview() = AppTheme {
    DetailTopAppBar(
        onNavigateUp = {},
        onFavorite = {}
    )
}