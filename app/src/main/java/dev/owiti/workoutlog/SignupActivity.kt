package dev.owiti.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var btnSignUp: Button
    lateinit var tilFirstName: TextInputLayout
    lateinit var tilLastName:TextInputLayout
    lateinit var tilEmail:TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilConfirmPassword: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var etLastName: TextInputEditText
    lateinit var etmail: TextInputEditText
    lateinit var etpassword: TextInputEditText
    lateinit var etConfirmPassword: TextInputEditText
    lateinit var tvLogin:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        btnSignUp=findViewById(R.id.btnSignUp)
        tilFirstName=findViewById(R.id.tilFirstName)
        tilLastName=findViewById(R.id.tilLastName)
        tilEmail=findViewById(R.id.tilEmail)
        tilPassword=findViewById(R.id.tilPassword)
        tilConfirmPassword=findViewById(R.id.tilConfirmPassword)
        etFirstName=findViewById(R.id.etFirstName)
        etLastName=findViewById(R.id.etLastName)
        etmail=findViewById(R.id.etmail)
        etpassword=findViewById(R.id.etpassword)
         tvLogin=findViewById(R.id.tvLogin)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)


        btnSignUp.setOnClickListener {
        validateSign()

        }
        tvLogin.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }


    }
    fun validateSign() {
        var name = etFirstName.text.toString()
        var name2 = etLastName.text.toString()
        var mail = etmail.text.toString()
        var pass = etpassword.text.toString()
        var confirm = etConfirmPassword.text.toString()

        if (name.isBlank()) {
            tilFirstName.error = "firstname_required"
        }
        if (name2.isBlank()) {
            tilLastName.error = "Last name required"
        }
        if (mail.isBlank()) {
            tilEmail.error = "email_required"
        }
        if (pass.isBlank()) {
            tilPassword.error = "password_required"
        }
        if (confirm.isBlank()) {
            tilConfirmPassword.error = "confirmpassword_required"
        }
        if (pass!= confirm) {
            tilPassword.error="password do not match"
        }
    }
}

