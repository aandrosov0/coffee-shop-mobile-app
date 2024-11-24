package coffee.shop.app.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coffee.shop.app.CoffeeViewModel
import coffee.shop.app.appModule
import coffee.shop.app.states.CoffeeSize
import coffee.shop.app.themes.AppTheme
import coffee.shop.data.localDataModule
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.KoinApplication

@Composable
fun DetailScreen(
    coffeeId: Long,
    modifier: Modifier = Modifier,
    coffeeViewModel: CoffeeViewModel = koinViewModel(),
    navController: NavController = rememberNavController()
) {
    val result by coffeeViewModel.uiState.collectAsState()
    val coffee = result.value.firstOrNull()
    var size by remember { mutableStateOf(CoffeeSize.M) }

    LaunchedEffect(Unit) {
        coffeeViewModel.getById(coffeeId)
    }

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            DetailTopAppBar(
                onFavorite = {},
                onNavigateUp = navController::navigateUp
            )
            if (coffee != null) {
                DetailProduct(
                    title = coffee.title,
                    type = coffee.type,
                    rating = coffee.rating,
                    reviews = coffee.reviews,
                    description = coffee.description,
                    size = coffee.size,
                    modifier = Modifier
                        .padding(
                            start = 24.dp, end = 24.dp,
                            bottom = 20.dp
                        )
                )
                DetailProductSize(
                    current = size,
                    onSizeChange = { size = it },
                    modifier = Modifier.padding(24.dp),
                )
            }
        }
        DetailBottomAppBar(
            price = coffee?.price ?: 0f,
            onBuy = {}
        )
    }
}

@Preview
@Composable
private fun DetailScreenPreview() = AppTheme {
    KoinApplication(application = { modules(localDataModule, appModule) }) {
        DetailScreen(coffeeId = 4)
    }
}