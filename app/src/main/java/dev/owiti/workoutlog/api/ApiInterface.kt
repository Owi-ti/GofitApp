package dev.owiti.workoutlog.api

import dev.owiti.workoutlog.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("/Login")
    suspend fun login (@Body LoginRequest: LoginRequest): Response<LoginResponse>


    @GET("/exercise-categories")
    suspend fun fetchExerciseCategories(@Header("Authorization") accessToken: String): Response<List<ExerciseCategory>>
}
