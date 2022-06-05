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
import java.net.PasswordAuthentication

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin:Button
    lateinit var tilEmail:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var etEmail:EditText
    lateinit var etPassword:EditText
    lateinit var tvSignup:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin=findViewById(R.id.btnLogin)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassword=findViewById(R.id.tilPassword)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)
        tvSignup=findViewById(R.id.tvSignup)

        btnLogin.setOnClickListener {
            val intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
            validate()
        }

        tvSignup.setOnClickListener {
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }
    }
    fun validate(){
        var email=etEmail.text.toString()
        var psw=etPassword.text.toString()

        if(email.isBlank()){
            etEmail.error="email required"

        }

        if (psw.isBlank()){
            etPassword.error="Password required"

        }

    }
}
