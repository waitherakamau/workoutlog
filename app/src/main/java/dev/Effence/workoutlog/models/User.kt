package dev.Effence.workoutlog.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("first_name")var firstName: String,
    @SerializedName("last_name") var lastName: String,
    @SerializedName("phone_number")var phoneNumber:String,
    var email: String,
    @SerializedName("user_id")var userId: String,




    )
