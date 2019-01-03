package com.example.yesidmarin.nutritionalplan.data.interactors

import com.example.yesidmarin.nutritionalplan.data.model.EmployeeModel
import com.example.yesidmarin.nutritionalplan.data.model.NutricionalPlan
import com.example.yesidmarin.nutritionalplan.data.repository.EmployeeRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import java.lang.Exception

class NutritionalInteractor
{

    private var employeeRepository = EmployeeRepository()
    private val realm = Realm.getDefaultInstance()


    fun createNutritionalPlan(name: String, id: Long): Boolean{
        val realm = Realm.getDefaultInstance()
        var isSuccess = false
        try {
            realm.executeTransaction {
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
        var plan: String
        val isQuery: MutableList<String> = ArrayList()
        if (nutritionalPlanQuery.count() > 0){
            for ( s in nutritionalPlanQuery.indices){
                plan = "it is ${nutritionalPlanQuery[s]?.name} and yours id is: ${nutritionalPlanQuery[s]?.id}"
                isQuery.add(plan)
            }
        }
        return isQuery
    }

    fun getAllEmployees(): Observable<MutableList<EmployeeModel>>? {
        return employeeRepository
            .getAllEmployees()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.flatMap {
                val response = mutableListOf<EmployeeModel>()
                for(ent in it){
                    val employeeModel = EmployeeModel().apply {
                        id = ent.id
                        employeeName = ent.employeeName
                        employeeSalary = ent.employeeSalary
                        employeeAge = ent.employeeAge
                        profileImage = ent.profileImage
                    }
                    response.add(employeeModel)
                }
                Observable.just(response)
            }
    }

    fun getEmployee(id: String): Observable<EmployeeModel>?{
        return  employeeRepository
            .getEmployee(id)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.flatMap {
                val response: EmployeeModel
                val employeeModel = EmployeeModel().apply {
                    this.id = it.id
                    employeeName = it.employeeName
                    employeeSalary = it.employeeSalary
                    employeeAge = it.employeeAge
                    profileImage = it.profileImage
                }
                 response = employeeModel
                Observable.just(response)
            }
    }


}