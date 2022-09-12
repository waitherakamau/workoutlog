package dev.Effence.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import dev.Effence.workoutlog.models.LoginRequest
import dev.Effence.workoutlog.models.LoginResponse
import dev.Effence.workoutlog.models.RegisterRequest
import dev.Effence.workoutlog.models.RegisterResponse
import dev.Effence.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    val userRepository=UserRepository()
    var loginResponseLiveData=MutableLiveData<LoginResponse>()
    val loginErrorLiveData=MutableLiveData<String?>()
    var registerResponseLiveData=MutableLiveData<RegisterResponse>()
    val registerErrorLiveData=MutableLiveData<String?>()


    fun loginUser(loginRequest:LoginRequest){
        viewModelScope.launch{
            val response=userRepository.loginUser(loginRequest)
            if (response.isSuccessful){
                loginResponseLiveData.postValue(response.body())

            }
            else{
                val error=response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }
        }
    }

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response=userRepository.registerUser(registerRequest)
            if (response.isSuccessful){
                registerResponseLiveData.postValue(response.body())
            }
//            else{
//                val error=response.errorBody()?.string()
//                loginErrorLiveData.postValue(error)
//            }
        }
    }

}