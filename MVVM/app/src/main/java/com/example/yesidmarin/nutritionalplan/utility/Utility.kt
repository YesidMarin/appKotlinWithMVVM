package com.example.yesidmarin.nutritionalplan.utility

import android.content.Context
import android.widget.Toast

open class Utility {
    companion object {
        fun showToast(context: Context, msn: String){
            Toast.makeText(context,msn, Toast.LENGTH_SHORT).show()
        }
    }
}