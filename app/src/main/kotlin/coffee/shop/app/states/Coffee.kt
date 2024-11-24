package coffee.shop.app.states

import coffee.shop.data.models.NetworkCoffee

data class Coffee(
    val id: Long = 0,
    val image: String = "",
    val title: String = "",
    val description: String = "",
    val type: String = "",
    val rating: Float = 0f,
    val reviews: Long = 0,
    val size: CoffeeSize = CoffeeSize.M,
    val price: Float = 0f,
)

fun NetworkCoffee.asState() = Coffee(
    id = id,
    image = image,
    title = title,
    description = description,
    type = type,
    rating = rating,
    reviews = reviews,
    size = size.asState(),
    price = price,
)