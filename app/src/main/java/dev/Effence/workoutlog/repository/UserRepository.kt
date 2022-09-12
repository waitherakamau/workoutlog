package dev.Effence.workoutlog.repository

import dev.Effence.workoutlog.ApiInterface.Apiclient
import dev.Effence.workoutlog.ApiInterface.ApiInterface
import dev.Effence.workoutlog.models.LoginRequest
import dev.Effence.workoutlog.models.RegisterRequest
import dev.Effence.workoutlog.models.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {

    val apiclient = Apiclient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest:LoginRequest)
    = withContext(Dispatchers.IO){
        val  response=apiclient.login(loginRequest)
        return@withContext response

    }

    suspend fun registerUser(registerRequest: RegisterRequest):Response<RegisterResponse>
    = withContext(Dispatchers.IO){
        val response=apiclient.registerUser(registerRequest)
        return@withContext response
    }
}


