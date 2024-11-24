package coffee.shop.data

import coffee.shop.data.repositories.NetworkCoffeeFakeRepository
import coffee.shop.data.repositories.CoffeeRepository
import org.koin.dsl.module

val dataModule = module {
    single<CoffeeRepository> { NetworkCoffeeFakeRepository() }
}

val localDataModule = module {
    single<CoffeeRepository> { NetworkCoffeeFakeRepository() }
}