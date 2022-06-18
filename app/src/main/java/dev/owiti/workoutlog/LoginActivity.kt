package dev.owiti.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    lateinit var btnLogin:Button
    lateinit var tilEmail:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var etemail: EditText
    lateinit var etPassword:EditText
    lateinit var tvSignup:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin=findViewById(R.id.btnLogin)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassword=findViewById(R.id.tilPassword)
        etemail=findViewById(R.id.etemail)
        etPassword=findViewById(R.id.etPassword)
        tvSignup=findViewById(R.id.tvSignup)

        btnLogin.setOnClickListener {
            val intent=Intent(this, HomeActivity::class.java)
            startActivity(intent)
            validateLogin()
//            startActivity(Intent(this,HomeActivity::class.java))
//            finish()
        }

        tvSignup.setOnClickListener {
            val intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }



    }


    fun validateLogin(){
        var email=etemail.text.toString()
        var password =etPassword.text.toString()
        var error=false

        if (email.isBlank()){
            tilEmail.error="email_required"
            error=true
        }
        if (password.isBlank()){
            tilPassword.error="Password required"
            error=true
        }
        if(!error){

        }
    }

}