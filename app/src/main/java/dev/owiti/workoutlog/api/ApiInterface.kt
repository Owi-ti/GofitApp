package dev.owiti.workoutlog.api

import dev.owiti.workoutlog.models.LoginRequest
import dev.owiti.workoutlog.models.LoginResponse
import dev.owiti.workoutlog.models.RegisterRequest
import dev.owiti.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("/Login")
    suspend fun login (@Body LoginRequest: LoginRequest): Response<LoginResponse>
}