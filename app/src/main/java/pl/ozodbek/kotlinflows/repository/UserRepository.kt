package pl.ozodbek.kotlinflows.repository

import pl.ozodbek.kotlinflows.networking.ApiService

class UserRepository(private val apiService: ApiService) {

     fun getGithubUsers() = apiService.getUsers()
}