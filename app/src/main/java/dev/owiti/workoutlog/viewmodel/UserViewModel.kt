package dev.owiti.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.owiti.workoutlog.models.LoginRequest
import dev.owiti.workoutlog.models.LoginResponse
import dev.owiti.workoutlog.models.RegisterRequest
import dev.owiti.workoutlog.models.RegisterResponse
import dev.owiti.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository= UserRepository()
    var loginResponseLiveData=MutableLiveData<LoginResponse>()
    val loginErrorLiveData= MutableLiveData<String?>()
    val registerResponseLiveData= MutableLiveData<RegisterResponse>()
    val registerErrorLiveData =MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch {
            val response= userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponseLiveData.postValue(response.body())
            }
            else{
                val error=response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }
        }
    }

    fun registerUser(registerRequest:RegisterRequest){
        viewModelScope.launch {
            val response= userRepository.registerUser(registerRequest)
            if (response.isSuccessful){
                registerResponseLiveData.postValue(response.body())
            }
//            else{
//                val error=response.errorBody()?.string()
//                signupErrorLiveData.postValue(error)
//            }
        }
    }

}