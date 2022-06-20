package dev.Effence.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.Effence.workoutlog.R
import dev.Effence.workoutlog.databinding.ActivityLoginBinding
import java.net.PasswordAuthentication

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btnLogin.setOnClickListener {

            validate()
        }

       binding. tvSignup.setOnClickListener {
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }

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
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }

    }
}
