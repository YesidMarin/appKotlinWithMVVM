package com.example.yesidmarin.nutritionalplan.views

import android.app.Application
import io.realm.Realm

class AplicationContext: Application(){

    lateinit var realm: Realm

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        realm = Realm.getDefaultInstance()

    }

}