package com.leandroid.system.teammanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leandroid.system.teammanagement.databinding.ActivityHomeBinding
import com.leandroid.system.teammanagement.ui.view.register.RegisterActivity

enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")


        binding.btReg.setOnClickListener{
            val int = Intent(this, RegisterActivity::class.java)
            startActivity(int)
        }


    }

    private fun setup(email : String, provider: String){

        title = "Inicio"
        val emailTextView : String = email

        val providerTextView: String = provider


    }



}