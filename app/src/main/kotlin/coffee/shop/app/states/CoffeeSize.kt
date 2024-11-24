package coffee.shop.app.states

import coffee.shop.data.models.NetworkCoffeeSize

enum class CoffeeSize {
    S,
    M,
    L
}

fun NetworkCoffeeSize.asState() = when (this) {
    NetworkCoffeeSize.S -> CoffeeSize.S
    NetworkCoffeeSize.M -> CoffeeSize.M
    NetworkCoffeeSize.L -> CoffeeSize.L
}