package dev.Effence.workoutlog.ApiInterface

import dev.Effence.workoutlog.models.LoginRequest
import dev.Effence.workoutlog.models.LoginResponse
import dev.Effence.workoutlog.models.RegisterRequest
import dev.Effence.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>


}