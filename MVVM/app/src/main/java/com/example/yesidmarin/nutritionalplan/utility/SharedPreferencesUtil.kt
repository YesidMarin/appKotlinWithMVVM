package com.example.yesidmarin.nutritionalplan.utility

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.yesidmarin.nutritionalplan.ApplicationContext

class SharedPreferencesUtil {
    companion object {
        fun getSharedPreferenceObject(): SharedPreferences {
            return ApplicationContext.getInstance().getSharedPreferences("exampleMVVM", MODE_PRIVATE)
        }

        fun <T: Any>savePreference(key: String, value: T){
            val prefs = getSharedPreferenceObject()
            val editor = prefs.edit()

            when(value){
                is Int -> editor.putInt(key, value)
                is Long -> editor.putLong(key, value)
                is Float -> editor.putFloat(key, value)
                is Boolean -> editor.putBoolean(key, value)
                is String -> editor.putString(key, value)
            }
            editor.commit()
        }

        fun <T: Any>getPreference(key: String, classType: Class<T>): T {
            val prefs = getSharedPreferenceObject()

            when(classType as T){
                is Int -> return (prefs.getInt(key, -1) as T)
                is Long -> return (prefs.getLong(key, -1) as T)
                is Float -> return (prefs.getFloat(key, (-0.0).toFloat()) as T)
                is Boolean -> return (prefs.getBoolean(key, false) as T)
                else -> {
                    return (prefs.getString(key, null) as T)
                }
            }
        }
    }
}