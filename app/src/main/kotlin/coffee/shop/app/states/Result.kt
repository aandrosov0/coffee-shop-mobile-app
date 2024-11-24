package coffee.shop.app.states

data class Result<T>(
    val value: List<T> = emptyList(),
    val isLoading: Boolean = false,
)
