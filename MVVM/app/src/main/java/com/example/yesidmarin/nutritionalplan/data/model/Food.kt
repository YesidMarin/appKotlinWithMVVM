package com.example.yesidmarin.nutritionalplan.data.model

import io.realm.RealmObject

open class Food: RealmObject() {
    open var name: String? = null
    open var calories: Float? = null
}