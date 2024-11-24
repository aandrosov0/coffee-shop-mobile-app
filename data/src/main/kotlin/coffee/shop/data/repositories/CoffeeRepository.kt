package coffee.shop.data.repositories

import coffee.shop.data.models.NetworkCoffee

interface CoffeeRepository {
    suspend fun getAll(): List<NetworkCoffee>
    suspend fun getById(id: Long): NetworkCoffee?
}