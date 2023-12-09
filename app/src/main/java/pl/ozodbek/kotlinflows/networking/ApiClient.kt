package pl.ozodbek.kotlinflows.networking

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import tech.thdev.network.flowcalladapterfactory.FlowCallAdapterFactory
import java.util.concurrent.TimeUnit


object ApiClient {

    private const val BASE_URL = "http://64.227.42.134:5075/"

    private val provideHttpClient =  OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()



    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideHttpClient)
            .addConverterFactory(createSerializationConverterFactory())
            .addCallAdapterFactory(FlowCallAdapterFactory())
            .build()

    }


    @OptIn(ExperimentalSerializationApi::class)
    fun createSerializationConverterFactory(): Converter.Factory {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }

        return json.asConverterFactory(contentType)
    }


}