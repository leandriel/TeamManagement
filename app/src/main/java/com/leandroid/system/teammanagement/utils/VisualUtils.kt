package com.leandroid.system.teammanagement.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class VisualUtils {
    companion object{
        fun showToast(context : Context,text : String, duration : Int){
            Toast.makeText(context,text,duration).show()
        }

        fun showAlert(context: Context, title: String, message: String, positiveTextTitle: String){
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
            builder.setMessage(message)
            builder.setPositiveButton(positiveTextTitle,null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}