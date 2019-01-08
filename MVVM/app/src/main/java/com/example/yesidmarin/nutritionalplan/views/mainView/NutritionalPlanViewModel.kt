package com.example.yesidmarin.nutritionalplan.views.mainView

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yesidmarin.nutritionalplan.data.interactors.NutritionalInteractor
import com.example.yesidmarin.nutritionalplan.data.model.EmployeeModel
import java.text.DecimalFormat


class NutritionalPlanViewModel: ViewModel() {

    private val nutritionalInteractor = NutritionalInteractor()
    private lateinit var listPlans: MutableLiveData<MutableList<String>>
    private lateinit var employees: MutableLiveData<MutableList<EmployeeModel>>
    lateinit var employee: MutableLiveData<EmployeeModel>

    // MutableLiveData variables initial
    init {
        if(!::listPlans.isInitialized && !::employees.isInitialized && !::employee.isInitialized){
            listPlans = MutableLiveData()
            employees = MutableLiveData()
            employee = MutableLiveData()
        }
    }
    // Add new nutritional plan in Realm
    fun addNewNutritionalPlan(name: String, id: String): Boolean{
        val idEmployee = id.toLong()
        return nutritionalInteractor.createNutritionalPlan(name, idEmployee)
    }

    // Get all nutritional plans
    fun queryNutritionalPlan():MutableLiveData<MutableList<String>>{
        val data = nutritionalInteractor.queryNutritionalPlan()
        listPlans.value = data
        return listPlans
    }

    // Get all employee
    fun getAllEmployee(): MutableLiveData<MutableList<EmployeeModel>> {
        nutritionalInteractor.getAllEmployees()?.subscribe {
            employees.value = it
        }
        return employees
    }

    // Show employee preload of getEmployee
    fun showEmployee(): MutableLiveData<EmployeeModel>{
        return employee
    }

    fun getEmployee(id: String){
        nutritionalInteractor.getEmployee(id)?.subscribe {
            employee.value = it
        }
    }

}
