package com.leandroid.system.teammanagement.utils

import android.content.Context
import android.widget.Toast

class VisualUtils {
    companion object{
        fun showToast(context : Context,text : String, duration : Int){
            Toast.makeText(context,text,duration).show()

        }
    }
}