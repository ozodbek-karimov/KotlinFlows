package pl.ozodbek.kotlinflows.networking

import retrofit2.http.GET
import kotlinx.coroutines.flow.Flow
import pl.ozodbek.kotlinflows.models.Profex

interface ApiService {

    @GET("api/common/posts")
    fun getUsers(): Flow<List<Profex>>

}