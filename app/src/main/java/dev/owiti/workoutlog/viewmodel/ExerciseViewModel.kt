package dev.owiti.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.owiti.workoutlog.api.ExerciseCategory
import dev.owiti.workoutlog.models.ExerciseCategory
import dev.owiti.workoutlog.repository.ExerciseRepository
import kotlinx.coroutines.launch

class ExerciseViewModel: ViewModel() {
    val exerciseRepository = ExerciseRepository()
    val exerciseCategoryLiveData = MutableLiveData<List<ExerciseCategory>>()
    val errorLiveData = MutableLiveData<String?>()


    suspend fun fetchExerciseCategories(accessToken: String) {
        viewModelScope.launch {
            val response = exerciseRepository.fetchExerciseCategory(accessToken)
            if (response.isSuccessful) {
                exerciseCategoryLiveData.postValue(response.body())

            } else {
                val errorMsg = response.errorBody()?.string()
                errorLiveData.postValue(errorMsg)
            }
        }

    }
}