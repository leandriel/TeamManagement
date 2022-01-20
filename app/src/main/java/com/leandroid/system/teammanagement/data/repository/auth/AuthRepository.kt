package com.leandroid.system.teammanagement.data.repository.auth

import com.leandroid.system.teammanagement.data.network.FirebaseManager

class AuthRepository(private val firebaseManager: FirebaseManager) {
    fun login(email: String, pass: String){
        firebaseManager.login(email, pass)
    }
}