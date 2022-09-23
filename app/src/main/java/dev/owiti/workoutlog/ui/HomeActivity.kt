package dev.owiti.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.owiti.workoutlog.R
import dev.owiti.workoutlog.databinding.ActivityHomeBinding
import dev.owiti.workoutlog.utilities.Constants
import dev.owiti.workoutlog.utilities.Constants.Companion.accessToken
import dev.owiti.workoutlog.viewmodel.ExerciseViewModel
import dev.owiti.workoutlog.viewmodel.UserViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var sharedPref : SharedPreferences
    val exerciseViewModel: ExerciseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvLogout.setOnClickListener {
            val intent=Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
            Logoutrequest()
        }

       casViews()
        setupBottomNav()
        sharedPref = getSharedPreferences(Constants.prefsFile, MODE_PRIVATE)
        val token =sharedPref.getString(Constants.accessToken,Constants.EMPTY_STRING)
        exerciseViewModel.fetchExerciseCategories(token!!)
    }

    override fun onResume() {
        super.onResume()
        exerciseViewModel.exerciseCategoryLiveData.observe(this, Observer {exe ->
            Toast.makeText(baseContext, "fetched ${exe.size} categories ",
                Toast.LENGTH_LONG
            ).show()
        }  )
        exerciseViewModel.errorLiveData.observe(this, Observer {
                error->
            Toast.makeText(this,error,Toast.LENGTH_LONG).show()
        })
    }

   fun casViews(){
        binding.fcvHome
        binding.bnvHome
}
    fun setupBottomNav() {
        binding.bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.plan -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.track -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else -> false
            }
        }

    }

    fun Logoutrequest () {
        sharedPref.edit().clear().commit()
//        startActivity(Intent(this, LoginActivity::class.java))
//        finish()
    }
}