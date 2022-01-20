package com.leandroid.system.teammanagement.ui.view.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leandroid.system.teammanagement.data.repository.auth.AuthRepository

class AuthViewModelFactory(val repository: AuthRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AuthRepository::class.java)
            .newInstance(repository)
    }
}