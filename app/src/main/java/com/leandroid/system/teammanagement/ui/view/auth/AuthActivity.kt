package com.leandroid.system.teammanagement.ui.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.leandroid.system.teammanagement.HomeActivity
import com.leandroid.system.teammanagement.ProviderType
import com.leandroid.system.teammanagement.R
import com.leandroid.system.teammanagement.data.network.FirebaseAuthListener
import com.leandroid.system.teammanagement.data.network.FirebaseManager
import com.leandroid.system.teammanagement.data.repository.auth.AuthRepository
import com.leandroid.system.teammanagement.databinding.ActivityAuthBinding
import com.leandroid.system.teammanagement.databinding.ActivityHomeBinding
import com.leandroid.system.teammanagement.utils.VisualUtils.Companion.showAlert

class AuthActivity : AppCompatActivity(), FirebaseAuthListener {
    private lateinit var binding: ActivityAuthBinding
    private val repository = AuthRepository(FirebaseManager(this))
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        setup()
        initViewModel()
    }

    private fun initViewModel(){
        val viewModelFactory = AuthViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(AuthViewModel::class.java)
    }


    private fun setup() {
        title = "autenticación" // pasar string a el xml string
        with(binding) {
            btLogin.setOnClickListener {
                if (etEmail.text.isNotEmpty() && etPass.text.isNotEmpty()) {
                    viewModel.login(etEmail.text.toString(),etPass.text.toString())
                }
            }
        }
    }
    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

    override fun loginResult(isSuccess: Boolean) {
        if (isSuccess) {
            showHome(binding.etEmail.text.toString(), ProviderType.BASIC)
        } else {
            showAlert(
                this, getString(R.string.alert_title_attention),
                getString(R.string.alert_message_auth),
                getString(R.string.alert_accept_positive)
            )
        }
    }

}