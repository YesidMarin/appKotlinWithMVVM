package com.example.yesidmarin.nutritionalplan.data.interactors

import com.example.yesidmarin.nutritionalplan.data.model.NutricionalPlan
import io.realm.Realm
import java.lang.Exception

class NutritionalInteractor() {

    private val realm = Realm.getDefaultInstance()

    fun createNutritionalPlan(name: String, id: Long): Boolean{
        val realm = Realm.getDefaultInstance()
        var isSuccess = false
        try {
            realm.executeTransaction {realm ->
                val nutritionalPlan = realm.createObject(NutricionalPlan::class.java, id)
                nutritionalPlan.name = name
                isSuccess = true
            }
        } catch (e:Exception){
            isSuccess = false
        }

        return isSuccess
    }

    fun queryNutritionalPlan():MutableList<String>{

        val nutritionalPlanQuery = realm.where(NutricionalPlan::class.java).findAll()!!
        var plan = ""
        var isQuery: MutableList<String> = ArrayList()
        if (nutritionalPlanQuery.count() > 0){
            for ( s in nutritionalPlanQuery.indices){
                plan = "it is ${nutritionalPlanQuery[s]?.name} and yours id is: ${nutritionalPlanQuery[s]?.id}"
                isQuery.add(plan)
            }
        }
        return isQuery
    }



}