package dev.Effence.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.Effence.workoutlog.databinding.ActivityHomeBinding
import dev.Effence.workoutlog.databinding.ActivityLoginBinding
import dev.Effence.workoutlog.databinding.ActivitySignup2Binding
import java.net.PasswordAuthentication

class signupActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignup2Binding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)
        binding=ActivitySignup2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSignup.setOnClickListener {
            val intent=Intent(this,signupActivity::class.java)
            startActivity(intent)
            validateSignup()

        }
    }
    fun validateSignup(){
        var FirstName=binding.etFirstName.text.toString()
        var LastName= binding.etLastName.text.toString()
        var email= binding.etEmail.text.toString()
        var Password=binding.etPassword.text.toString()
        var Confirm=binding.etConfirm.text.toString()


        if (FirstName.isBlank()){
             binding.etFirstName.error="FirstName required"

        }

        if(LastName.isBlank()){
           binding. etLastName.error="LastName required"

        }

        if(email.isBlank()){
            binding.etEmail.error="email required"
        }

        if(Password.isBlank()){
            binding.etPassword.error="Password required"
        }

        if(Confirm.isBlank()){

           binding. etConfirm.error="confirm required"
        }


    }
}