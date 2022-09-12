package dev.Effence.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.Effence.workoutlog.R
import dev.Effence.workoutlog.databinding.ActivitySignup2Binding
import dev.Effence.workoutlog.ApiInterface.ApiInterface
import dev.Effence.workoutlog.models.RegisterRequest
import dev.Effence.workoutlog.models.RegisterResponse
import dev.Effence.workoutlog.ApiInterface.Apiclient
import dev.Effence.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignup2Binding
    val userViewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)
        binding = ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            validateSignup()

        }
    }

    fun validateSignup() {
        var firstName = binding.etFirstName.text.toString()
        var lastName = binding.etLastName.text.toString()
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var confirm = binding.etConfirm.text.toString()
        var phoneNumber = binding.etNumber.toString()

        var error = false

        if (firstName.isBlank()) {
            binding.etFirstName.error = "FirstName required"

        }

        if (lastName.isBlank()) {
            binding.etLastName.error = "LastName required"

        }

        if (email.isBlank()) {
            binding.etEmail.error = "email required"
        }

        if (password.isBlank()) {
            binding.etPassword.error = "Password required"
        }

        if (confirm.isBlank()) {

            binding.etConfirm.error = "confirm required"
        }

        if (phoneNumber.isBlank()) {
            binding.etNumber.error = "phonenumber required"
        }

        if (!error) {
            val registerRequest = RegisterRequest(firstName, lastName, email, phoneNumber, password)
            userViewModel.registerUser(registerRequest)
//            userViewModel.registerU(registerRequest)

        }

    }

    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { signupResponse ->
            Toast.makeText(baseContext, signupResponse.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, LoginActivity::class.java))


        })
        userViewModel.registerErrorLiveData.observe(this, Observer { signupError ->
            Toast.makeText(baseContext, signupError, Toast.LENGTH_LONG).show()


        })
    }
}