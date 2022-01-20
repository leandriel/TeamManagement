package com.leandroid.system.teammanagement.data.network

import com.google.firebase.auth.FirebaseAuth

class FirebaseManager(private val authListener: FirebaseAuthListener? = null){

    fun login(email: String, pass: String){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener() {
             authListener?.loginResult(it.isSuccessful)
        }
    }
}