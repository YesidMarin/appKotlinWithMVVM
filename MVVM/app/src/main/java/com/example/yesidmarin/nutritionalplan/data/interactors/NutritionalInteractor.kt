package com.example.yesidmarin.nutritionalplan.data.interactors

import com.example.yesidmarin.nutritionalplan.data.dto.EmpleoyeeDTO
import com.example.yesidmarin.nutritionalplan.data.model.EmpleoyeeModel
import com.example.yesidmarin.nutritionalplan.data.model.NutricionalPlan
import com.example.yesidmarin.nutritionalplan.data.repository.EmpleoyeeRepository
import com.example.yesidmarin.nutritionalplan.data.repository.IEmpleoyeeRepository
import io.reactivex.Observable
import io.realm.Realm
import java.lang.Exception
import javax.inject.Inject

class NutritionalInteractor() {

    private var empleoyeeRepository = EmpleoyeeRepository()

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
        val isQuery: MutableList<String> = ArrayList()
        if (nutritionalPlanQuery.count() > 0){
            for ( s in nutritionalPlanQuery.indices){
                plan = "it is ${nutritionalPlanQuery[s]?.name} and yours id is: ${nutritionalPlanQuery[s]?.id}"
                isQuery.add(plan)
            }
        }
        return isQuery
    }

    fun getEmpleoyees(): Observable<MutableList<EmpleoyeeModel>>? {
        return empleoyeeRepository
            .getEmpleoyees()?.flatMap {
                var response = mutableListOf<EmpleoyeeModel>()
                for(ent in it){
                    var empleoyeeModel = EmpleoyeeModel().apply {
                        id = ent.id
                        employeeName = ent.employeeName
                        empleoyeeSalary = ent.empleoyeeSalary
                        empleoyeeAge = ent.empleoyeeAge
                    }
                    response.add(empleoyeeModel)
                }
                Observable.just(response)
            }
    }


}