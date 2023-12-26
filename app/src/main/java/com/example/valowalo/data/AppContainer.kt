package com.example.valowalo.data

import android.content.Context
import com.example.valowalo.network.AgentApiService
import com.example.valowalo.network.NetworkConnectionInterceptor
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface AppContainer {
    val agentsRepository: AgentsRepository
}

class DefaultAppContainer(private val context: Context) : AppContainer {

    private val networkCheck = NetworkConnectionInterceptor(context)
    private val client = OkHttpClient.Builder()
        .addInterceptor(networkCheck)
        .build()

    private val baseUrl = "https://valorant-api.com/v1/agents"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType()),
        )
        .baseUrl(baseUrl)
        .client(client)
        .build()

    private val retrofitService: AgentApiService by lazy {
        retrofit.create(AgentApiService::class.java)
    }

    override val agentsRepository: AgentsRepository by lazy {
        ApiAgentsRepository(retrofitService)
    }
}
