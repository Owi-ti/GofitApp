package dev.owiti.workoutlog.retrofit

import dev.owiti.workoutlog.models.RegisterRequest
import dev.owiti.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
}