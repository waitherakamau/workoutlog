package dev.Effence.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.net.PasswordAuthentication

class signupActivity : AppCompatActivity() {
    lateinit var tillFirstName: TextInputLayout
    lateinit var etFirstName:TextInputEditText
    lateinit var tilLastName: TextInputLayout
    lateinit var etLastName:TextInputEditText
    lateinit var tilemail: TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var tilPassword:TextInputLayout
    lateinit var etPassword:TextInputEditText
    lateinit var btnSignup:Button
    lateinit var tilConfirm:TextInputLayout
    lateinit var etConfirm:TextInputEditText
    lateinit var tvLogin:TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup2)
        tillFirstName=findViewById(R.id.tillFirstName)
        etFirstName=findViewById(R.id.etFirstName)
        tilLastName=findViewById(R.id.tilLastName)
        etLastName=findViewById(R.id.etLastName)
        tilemail=findViewById(R.id.tilEmail)
        etEmail=findViewById(R.id.etEmail)
        tilPassword=findViewById(R.id.tilPassword)
        etPassword=findViewById(R.id.etPassword)
        btnSignup=findViewById(R.id.btnSignup)
        tilConfirm=findViewById(R.id.tilConfirm)
        etConfirm=findViewById(R.id.etConfirm)

        btnSignup.setOnClickListener {
            val intent=Intent(this,signupActivity::class.java)
            startActivity(intent)
            validateSignup()

        }
    }
    fun validateSignup(){
        var FirstName=etFirstName.text.toString()
        var LastName=etLastName.text.toString()
        var email=etEmail.text.toString()
        var Password=etPassword.text.toString()
        var Confirm=etConfirm.text.toString()


        if (FirstName.isBlank()){
            etFirstName.error="FirstName required"

        }

        if(LastName.isBlank()){
            etLastName.error="LastName required"

        }

        if(email.isBlank()){
            etEmail.error="email required"
        }

        if(Password.isBlank()){
            etPassword.error="Password required"
        }

        if(Confirm.isBlank()){

            etConfirm.error="confirm required"
        }


    }
}