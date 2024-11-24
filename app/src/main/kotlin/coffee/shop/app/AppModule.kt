package coffee.shop.app

import org.koin.dsl.module

val appModule = module {
    single { CoffeeViewModel(get()) }
}