package dev.owiti.workoutlog.repository

import dev.owiti.workoutlog.api.ApiClient
import dev.owiti.workoutlog.api.ApiInterface
import dev.owiti.workoutlog.models.LoginRequest
import dev.owiti.workoutlog.models.RegisterRequest
import dev.owiti.workoutlog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun  loginUser(loginRequest: LoginRequest)= withContext(Dispatchers.IO){
        val response = apiClient.login(loginRequest)
        return@withContext response
    }
    suspend fun  registerUser(registerRequest:RegisterRequest):Response<RegisterResponse>
    = withContext(Dispatchers.IO){
        val response = apiClient.registerUser(registerRequest)
        return@withContext response
    }
}