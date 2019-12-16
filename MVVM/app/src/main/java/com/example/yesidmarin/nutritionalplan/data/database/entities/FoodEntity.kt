package com.example.yesidmarin.nutritionalplan.data.database.entities

import io.realm.RealmObject

open class FoodEntity: RealmObject() {
    open var name: String? = null
    open var calories: Float? = null
}