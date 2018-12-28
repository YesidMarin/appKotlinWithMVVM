package com.example.yesidmarin.nutritionalplan.data.model


import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class NutricionalPlan(@PrimaryKey open var id: Long = 0,
                                           open var name: String = ""
): RealmObject()