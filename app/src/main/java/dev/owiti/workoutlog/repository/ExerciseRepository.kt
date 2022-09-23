package dev.owiti.workoutlog.repository

import dev.owiti.workoutlog.api.ApiClient
import dev.owiti.workoutlog.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

 class ExerciseRepository{
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)  //Instantiate api client.
    suspend fun fetchExerciseCategory(accessToken: String)= withContext(Dispatchers.IO){
        return@withContext apiClient.fetchExerciseCategories(accessToken)

    }
}
