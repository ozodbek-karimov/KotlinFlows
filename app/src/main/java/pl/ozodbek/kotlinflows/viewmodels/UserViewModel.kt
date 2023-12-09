package pl.ozodbek.kotlinflows.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import pl.ozodbek.kotlinflows.models.Profex
import pl.ozodbek.kotlinflows.networking.ApiClient
import pl.ozodbek.kotlinflows.networking.ApiService
import pl.ozodbek.kotlinflows.repository.UserRepository

class UserViewModel : ViewModel() {

    private val stateFlow = MutableStateFlow<Result<List<Profex>>>(Result.success(emptyList()))

    private val apiService = ApiClient.getRetrofit().create(ApiService::class.java)

    private val userRepository = UserRepository(apiService)

    init {
        fetchUser()
    }

    private fun fetchUser() {
        viewModelScope.launch {
            userRepository.getGithubUsers()
                .collect { result ->
                    stateFlow.emit(Result.success(result))
                }
        }
    }

    fun getStateFlow(): StateFlow<Result<List<Profex>>> {
        return stateFlow
    }
}