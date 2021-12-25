package com.leandroid.system.teammanagement

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FilterQueryProvider
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setup()
    }

    private fun setup(){

        title = "autenticación"

        val etPass = findViewById<EditText>(R.id.et_pass)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val btLogin = findViewById<Button>(R.id.bt_login)
        btLogin.setOnClickListener{
            if(etEmail.text.isNotEmpty() && etPass.text.isNotEmpty()){

                FirebaseAuth.getInstance().signInWithEmailAndPassword(etEmail.text.toString(),
                    etPass.text.toString()).addOnCompleteListener() {
                        if(it.isSuccessful){
                            showHome(it.result?.user?.email ?:"",ProviderType.BASIC)
                        }else{
                            showAlert()
                        }
                }
            }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando el usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType){
        val homeIntent = Intent(this, HomeActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }

}