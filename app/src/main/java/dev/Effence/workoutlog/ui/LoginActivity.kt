package dev.Effence.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.Effence.workoutlog.databinding.ActivityLoginBinding
import dev.Effence.workoutlog.models.LoginRequest
import dev.Effence.workoutlog.models.LoginResponse
import dev.Effence.workoutlog.viewmodel.UserViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedprefs:SharedPreferences
    val UserViewModel: UserViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedprefs=getSharedPreferences("WORKOprofileIdUT_PREFS", MODE_PRIVATE)




        binding.btnLogin.setOnClickListener {

            validate()
        }

       binding. tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        UserViewModel.loginResponseLiveData.observe(this, Observer{ loginResponse->
            Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG).show()
            saveLoginDetails(loginResponse!!)
            startActivity(Intent(baseContext,HomeActivity::class.java))
            finish()
        })
        UserViewModel.loginErrorLiveData.observe(this,Observer{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
    fun validate(){
        var email= binding.etEmail.text.toString()
        var psw= binding.etPassword.text.toString()
        var error =false

        if(email.isBlank()){
            binding.etEmail. error="email required"
            error = true

        }

        if (psw.isBlank()){
           binding. etPassword.error="Password required"
            error = true

        }
        if (!error){
            var loginRequest=LoginRequest(email, psw)
            binding.pdLogin.visibility=View.GONE
           UserViewModel.loginUser(loginRequest)
            startActivity(Intent(this,HomeActivity::class.java))
//            makeLoginRequest(loginRequest)

            finish()
        }

    }
//    fun makeLoginRequest(LoginRequest:LoginRequest){
//        var apiClient=Apiclient.buildApiClient(ApiInterface::class.java)
//        val request=apiClient.login(LoginRequest)
//
//
//        request.enqueue(object :Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//                binding.pdLogin.visibility=View.GONE
//                if (response.isSuccessful) {
//                    val loginResponse=response.body()
//
//
//
//                } else {
//                    val error = response.errorBody()?.string()
//                }
//            }
//
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                binding.pdLogin.visibility=View.GONE
//                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//            }
//        }
//
//        )
//    }
    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedprefs.edit()
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("PROFILE_ID",loginResponse.profileId)
        editor.apply()



    }
}
