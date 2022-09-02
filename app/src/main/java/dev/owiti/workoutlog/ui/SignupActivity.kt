package dev.owiti.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.owiti.workoutlog.databinding.ActivitySignupBinding
import dev.owiti.workoutlog.models.RegisterRequest
import dev.owiti.workoutlog.models.RegisterResponse
import dev.owiti.workoutlog.retrofit.ApiClient
import dev.owiti.workoutlog.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }


    }

    fun validateSign() {
        var name = binding.etFirstName.text.toString()
        var name2 = binding.etLastName.text.toString()
        var phone = binding.etPhoneNumber.text.toString()
        var mail = binding.etmail.text.toString()
        var pass = binding.etpassword.text.toString()
        var confirm = binding.etConfirmPassword.text.toString()



        var error= false
        if (name.isBlank()) {
            binding.tilFirstName.error = "firstname_required"
        }
        if (name2.isBlank()) {
            error =true
            binding.tilLastName.error = "Last name required"
        }
        if (pass.isBlank()) {
            error =true
            binding.tilPhoneNumber.error = "number_required"
        }

        if (mail.isBlank()) {
            error =true
            binding.tilEmail.error = "email_required"
        }
        if (phone.isBlank()) {
            error =true
            binding.tilPassword.error = "password_required"
        }
        if (confirm.isBlank()) {
            error =true
            binding.tilConfirmPassword.error = "confirmpassword_required"
        }
        if (pass!= confirm) {
            error =true
            binding.tilPassword.error="password do not match"
        }
        if(!error){
            val  registerRequest=RegisterRequest(name, name2, mail, phone, pass)

            makeRegistrationRequest(registerRequest)
        }
    }
     fun makeRegistrationRequest(registerRequest: RegisterRequest){
          var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
         var  request= apiClient.registerUser(registerRequest)

         request.enqueue(object :Callback<RegisterResponse> {
             override fun onResponse(
                 call: Call<RegisterResponse>,
                 response: Response<RegisterResponse>
             ) {
                 if (response.isSuccessful){
                     var message = response.body()?.message
                     Toast.makeText(baseContext,message,Toast.LENGTH_LONG).show()
                     //intent to login
                 }else{
                     val error = response.errorBody()?.string()
                     Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
                 }
             }

             override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                 Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
             }
         })

     }
}

