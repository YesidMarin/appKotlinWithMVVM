package com.example.yesidmarin.nutritionalplan.views.employeesView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yesidmarin.nutritionalplan.R
import com.example.yesidmarin.nutritionalplan.data.model.EmployeeModel
import com.example.yesidmarin.nutritionalplan.views.mainView.NutritionalPlanViewModel
import kotlinx.android.synthetic.main.activity_employees.*

class EmployeeViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recycleViewEmployees.layoutManager = layoutManager
        recycleViewEmployees.setHasFixedSize(true)

        val nutritionalPlanViewModel = ViewModelProviders.of(this).get(NutritionalPlanViewModel::class.java)
        nutritionalPlanViewModel.getAllEmployee().observe(this, Observer<List<EmployeeModel>>{
            recycleViewEmployees.adapter = EmployeeViewAdapter(it)
        })

    }

}


