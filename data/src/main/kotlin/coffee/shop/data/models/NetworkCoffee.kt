package coffee.shop.data.models

data class NetworkCoffee(
    val id: Long,
    val image: String,
    val title: String,
    val description: String,
    val type: String,
    val rating: Float,
    val reviews: Long,
    val size: NetworkCoffeeSize,
    val price: Float,
)
