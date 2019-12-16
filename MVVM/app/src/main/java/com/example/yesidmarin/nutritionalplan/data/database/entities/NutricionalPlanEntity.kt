package com.example.yesidmarin.nutritionalplan.data.database.entities


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NutricionalPlanEntity(): RealmObject(){
    @PrimaryKey
    var id: Long = 0
    var name: String = ""
}