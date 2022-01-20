package com.leandroid.system.teammanagement.ui.view.auth

import androidx.lifecycle.ViewModel
import com.leandroid.system.teammanagement.data.repository.auth.AuthRepository

class AuthViewModel(private val repository: AuthRepository): ViewModel() {
    fun login(email: String, pass: String ){
        repository.login(email, pass)
    }
}