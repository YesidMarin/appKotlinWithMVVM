package com.example.yesidmarin.nutritionalplan.utility

import com.example.yesidmarin.nutritionalplan.ApplicationContext

class RUtil {
    companion object {
        fun R_string(resId: Int): String{
            return  ApplicationContext.getInstance().getString(resId)
        }
    }
}