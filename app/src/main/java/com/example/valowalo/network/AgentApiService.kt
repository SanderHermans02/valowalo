package com.example.valowalo.network

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET

interface AgentApiService {
    // suspend is added to force the user to call this in a coroutine scope
    @GET("tasks")
    suspend fun getTasks(): List<ApiAgent>
}

// helper function
fun AgentApiService.getTasksAsFlow(): Flow<List<ApiAgent>> = flow {
    try {
        emit(getTasks())
    } catch (e: Exception) {
        Log.e("API", "getTasksAsFlow: " + e.stackTraceToString())
    }
}
