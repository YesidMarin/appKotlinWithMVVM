package com.example.yesidmarin.nutritionalplan

import android.app.Application
import com.example.yesidmarin.nutritionalplan.utility.RUtil
import com.example.yesidmarin.nutritionalplan.utility.SharedPreferencesUtil
import io.realm.Realm

class ApplicationContext: Application(){

    lateinit var realm: Realm

    override fun onCreate() {
        super.onCreate()

        instance = this
        Realm.init(this)
        realm = Realm.getDefaultInstance()

        setupInitialSharedPreferences()
    }

    private fun setupInitialSharedPreferences(){
        SharedPreferencesUtil.savePreference(RUtil.R_string(R.string.shared_key_userType), RUtil.R_string(R.string.userType))
    }

    companion object {
        private lateinit var instance: ApplicationContext

        fun getInstance(): ApplicationContext {
            return instance
        }
    }

}