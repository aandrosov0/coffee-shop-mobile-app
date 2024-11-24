package coffee.shop.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coffee.shop.app.R
import coffee.shop.app.themes.AppTheme

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedItem: String = "home"
) {
    val items = listOf(
        "home" to R.drawable.home,
        "favorite" to R.drawable.heart,
        "cart" to R.drawable.bag,
        "notifications" to R.drawable.notification
    )

    NavigationBar(
        modifier = modifier
            .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        containerColor = MaterialTheme.colorScheme.surface,
    ) {
        items.forEach { item ->
            val selected = item.first == selectedItem
            val indicationColor = if (selected) {
                MaterialTheme.colorScheme.primary
            } else {
                Color.Transparent
            }

            NavigationBarItem(
                selected = selected,
                onClick = {},
                icon = {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(6.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Icon(
                            painter = painterResource(item.second),
                            contentDescription = null
                        )
                        Spacer(
                            modifier = Modifier
                                .background(
                                    color = indicationColor,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .size(10.dp, 5.dp)
                                .padding(top = 6.dp)
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurface.copy(.64f),
                    indicatorColor = Color.Transparent
                ),
            )
        }
    }
}

@Preview
@Composable
private fun BottomAppBarPreview() = AppTheme {
    BottomNavigationBar()
}