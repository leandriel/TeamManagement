package com.leandroid.system.teammanagement

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.leandroid.system.teammanagement.databinding.ActivityHomeBinding
import com.leandroid.system.teammanagement.databinding.ActivityRegisterBinding
import com.leandroid.system.teammanagement.utils.VisualUtils
import java.util.*
import kotlin.collections.HashMap

class RegisterActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private val dialog = DatePickerFragment.newInstance(this)
    private lateinit var binding: ActivityRegisterBinding

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)





        binding.etDateReg.setOnClickListener {
            showDatePickerDialog()
        }

        binding.btRegister.setOnClickListener{

            if(validarForm()){
                registerUser()
            }
        }

        initSpinner()


    }

    private fun showDatePickerDialog() =

          dialog.show(supportFragmentManager, "datePicker")


    override fun onDateSet(view: DatePicker?, year: Int, month: Int, day: Int) {
        val selectedDate = day.toString() + " / " + (month + 1) + " / " + year
        val et_date_reg = findViewById<EditText>(R.id.et_date_reg)

        et_date_reg.setText(selectedDate)
    }


    private fun initSpinner() {
        val divisiones = resources.getStringArray(R.array.Divisiones)
        val spinner = findViewById<Spinner>(R.id.sp_division_reg)

        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item,divisiones)
        spinner.adapter = adaptador




    }



    private fun validarForm(): Boolean {
        var esValido = true

        if (TextUtils.isEmpty(binding.etNameReg.text.toString())) {
            // Si la propiedad error tiene valor, se muestra el aviso.
            binding.etNameReg.error = "Requerido"
            esValido = false
        } else binding.etNameReg.error = null

        if (TextUtils.isEmpty(binding.etSurnameReg.text.toString())) {
            binding.etSurnameReg.error = "Requerido"
            esValido = false
        } else binding.etSurnameReg.error = null

        if (TextUtils.isEmpty(binding.etEmailReg.text.toString())) {
            binding.etEmailReg.error = "Requerido"
            esValido = false
        } else binding.etEmailReg.error = null

        if (TextUtils.isEmpty(binding.etDateReg.text.toString())) {
            binding.etDateReg.error = "Requerido"
            esValido = false
        } else binding.etDateReg.error = null

        if (TextUtils.isEmpty(binding.etDniReg.text.toString())) {
            binding.etDniReg.error = "Requerido"
            esValido = false
        } else binding.etDniReg.error = null

        if (TextUtils.isEmpty(binding.etTelReg.text.toString())) {
            binding.etTelReg.error = "Requerido"
            esValido = false
        } else binding.etTelReg.error = null

        if (TextUtils.isEmpty(binding.etPassReg.text.toString())) {

            binding.etPassReg.error = "Requerido"
            esValido = false

        }
        if(binding.etPassReg.text.toString().length<6){
            Toast.makeText(this,"El password requiere minimo 6 digitos",Toast.LENGTH_LONG).show()
            esValido = false
        }
        else binding.etPassReg.error = null



        return esValido
    }



    private fun registerUser(){
        db.collection("users").document("email").set(hashMapOf("name" to "leo"))
            .addOnCompleteListener {
                print(it)
            }
            .addOnFailureListener {
                print(it)
            }
       FirebaseAuth.getInstance().createUserWithEmailAndPassword(binding.etEmailReg.text.toString(),
            binding.etPassReg.text.toString())

            .addOnCompleteListener() {
            if(it.isSuccessful){

                db.collection("users").document(binding.etEmailReg.text.toString()).set(
                    hashMapOf("name" to binding.etNameReg.text.toString(),
                        "surname" to binding.etSurnameReg.text.toString(),
                        "email" to binding.etEmailReg.text.toString(),
                        "date" to binding.etDateReg.text.toString(),
                        "dni" to binding.etDniReg.text.toString(),
                        "phone" to binding.etTelReg.text.toString(),
                        "division" to binding.spDivisionReg.selectedItem.toString(),
                        "password" to binding.etPassReg.text.toString()

                    )
                )



            }else{
                Toast.makeText(this,"No se logro crear el usuario",Toast.LENGTH_LONG).show()
            }
        }
    }

}