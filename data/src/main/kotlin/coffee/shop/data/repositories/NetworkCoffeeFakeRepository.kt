package coffee.shop.data.repositories

import coffee.shop.data.models.NetworkCoffee
import coffee.shop.data.models.NetworkCoffeeSize
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.seconds

class NetworkCoffeeFakeRepository : CoffeeRepository {
    private val networkCoffees = listOf(
        NetworkCoffee(
            id = 1L,
            image = "https://example.com/images/espresso.jpg",
            title = "Espresso",
            description = "Strong and bold coffee.",
            type = "Espresso",
            rating = 4.5f,
            reviews = 150L,
            size = NetworkCoffeeSize.S,
            price = 2.50f
        ),
        NetworkCoffee(
            id = 2L,
            image = "https://example.com/images/latte.jpg",
            title = "Latte",
            description = "Smooth and creamy coffee.",
            type = "Latte",
            rating = 4.7f,
            reviews = 200L,
            size = NetworkCoffeeSize.M,
            price = 3.50f
        ),
        NetworkCoffee(
            id = 3L,
            image = "https://example.com/images/cappuccino.jpg",
            title = "Cappuccino",
            description = "Rich espresso with steamed milk and foam.",
            type = "Cappuccino",
            rating = 4.6f,
            reviews = 180L,
            size = NetworkCoffeeSize.M,
            price = 3.75f
        ),
        NetworkCoffee(
            id = 4L,
            image = "https://example.com/images/americano.jpg",
            title = "Americano",
            description = "Espresso with hot water.",
            type = "Americano",
            rating = 4.3f,
            reviews = 120L,
            size = NetworkCoffeeSize.L,
            price = 2.8f
        ),
        NetworkCoffee(
            id = 5L,
            image = "https://example.com/images/mocha.jpg",
            title = "Mocha",
            description = "Chocolatey coffee with steamed milk.",
            type = "Mocha",
            rating = 4.8f,
            reviews = 250L,
            size = NetworkCoffeeSize.M,
            price = 4f
        ),
        NetworkCoffee(
            id = 6L,
            image = "https://example.com/images/flat_white.jpg",
            title = "Flat White",
            description = "Rich espresso with velvety microfoam.",
            type = "Flat White",
            rating = 4.4f,
            reviews = 160L,
            size = NetworkCoffeeSize.L,
            price = 3.9f
        ),
        NetworkCoffee(
            id = 7L,
            image = "https://example.com/images/irish_coffee.jpg",
            title = "Irish Coffee",
            description = "Coffee with whiskey and cream.",
            type = "Irish Coffee",
            rating = 4.2f,
            reviews = 90L,
            size = NetworkCoffeeSize.L,
            price = 5.5f
        ),
        NetworkCoffee(
            id = 8L,
            image = "https://example.com/images/affogato.jpg",
            title = "Affogato",
            description = "Vanilla ice cream topped with hot espresso.",
            type = "Affogato",
            rating = 4.9f,
            reviews = 110L,
            size = NetworkCoffeeSize.S,
            price = 4.5f
        )
    )

    override suspend fun getAll() =
        networkCoffees

    override suspend fun getById(id: Long) = networkCoffees.find { coffee -> coffee.id == id }
}