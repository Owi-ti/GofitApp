package dev.owiti.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.owiti.workoutlog.databinding.ActivityLoginBinding
import dev.owiti.workoutlog.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {
        validateSign()

        }
        binding.tvLogin.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }


    }
    fun validateSign() {
        var name = binding.etFirstName.text.toString()
        var name2 = binding.etLastName.text.toString()
        var mail = binding.etmail.text.toString()
        var pass = binding.etpassword.text.toString()
        var confirm = binding.etConfirmPassword.text.toString()

        if (name.isBlank()) {
            binding.tilFirstName.error = "firstname_required"
        }
        if (name2.isBlank()) {
            binding.tilLastName.error = "Last name required"
        }
        if (mail.isBlank()) {
            binding.tilEmail.error = "email_required"
        }
        if (pass.isBlank()) {
            binding.tilPassword.error = "password_required"
        }
        if (confirm.isBlank()) {
            binding.tilConfirmPassword.error = "confirmpassword_required"
        }
        if (pass!= confirm) {
            binding.tilPassword.error="password do not match"
        }
    }
}

