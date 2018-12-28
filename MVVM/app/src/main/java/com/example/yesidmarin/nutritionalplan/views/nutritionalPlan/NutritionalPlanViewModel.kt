package com.example.yesidmarin.nutritionalplan.views.nutritionalPlan

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yesidmarin.nutritionalplan.data.interactors.NutritionalInteractor
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat.getSystemService


class NutritionalPlanViewModel: ViewModel() {

    private val nutritionalInteractor = NutritionalInteractor()
    private lateinit var listPlans: MutableLiveData<MutableList<String>>

    init {
        if(!::listPlans.isInitialized){
            listPlans = MutableLiveData()
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

}
