package coffee.shop.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coffee.shop.app.states.Coffee
import coffee.shop.app.states.Result
import coffee.shop.app.states.asState
import coffee.shop.data.repositories.CoffeeRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoffeeViewModel(
    private val repository: CoffeeRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(Result<Coffee>())
    val uiState = _uiState.asStateFlow()

    private var gettingAllJob: Job? = null
    private var gettingByIdJob: Job? = null

    fun getAll() {
        gettingAllJob?.cancel()
        gettingAllJob = viewModelScope.launch {
            _uiState.value = Result(isLoading = true)

            val coffeeList = repository.getAll().map {
                coffee -> coffee.asState()
            }

            _uiState.value = Result(value = coffeeList)
        }
    }

    fun getById(id: Long) {
        gettingByIdJob?.cancel()
        gettingByIdJob = viewModelScope.launch {
            _uiState.value = Result(isLoading = true)

            val coffee = repository.getById(id)

            if (coffee == null) {
                _uiState.value = Result()
            } else {
                _uiState.value = Result(value = listOf(coffee.asState()))
            }
        }
    }
}