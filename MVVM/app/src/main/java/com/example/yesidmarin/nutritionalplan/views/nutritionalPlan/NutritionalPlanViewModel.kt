package com.example.yesidmarin.nutritionalplan.views.nutritionalPlan

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yesidmarin.nutritionalplan.data.interactors.NutritionalInteractor
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat.getSystemService
import com.example.yesidmarin.nutritionalplan.data.dto.EmpleoyeeDTO
import com.example.yesidmarin.nutritionalplan.data.model.EmpleoyeeModel
import com.example.yesidmarin.nutritionalplan.data.repository.EmpleoyeeRepository
import com.example.yesidmarin.nutritionalplan.data.repository.IEmpleoyeeRepository
import io.reactivex.Observable
import javax.inject.Inject


class NutritionalPlanViewModel: ViewModel() {

    private val nutritionalInteractor = NutritionalInteractor()
    private lateinit var listPlans: MutableLiveData<MutableList<String>>
    internal lateinit var empleoyees: MutableLiveData<MutableList<EmpleoyeeModel>>
    init {
        if(!::listPlans.isInitialized){
            listPlans = MutableLiveData()
        }
        if(!::empleoyees.isInitialized){
            empleoyees = MutableLiveData()
        }

    }

    fun addNewNutritionalPlan(name: String, id: String): Boolean{
        val id = id.toLong()
        return nutritionalInteractor.createNutritionalPlan(name, id)
    }

    fun queryNutritionalPlan():MutableLiveData<MutableList<String>>{
        var data = nutritionalInteractor.queryNutritionalPlan()
        listPlans.value = data
        return listPlans
    }


    fun getEmpleoyees(): MutableLiveData<MutableList<EmpleoyeeModel>> {
        nutritionalInteractor.getEmpleoyees()?.subscribe {
            empleoyees.value = it
        }
        return empleoyees
    }
}
