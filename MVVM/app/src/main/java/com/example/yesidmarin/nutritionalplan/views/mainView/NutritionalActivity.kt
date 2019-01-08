package com.example.yesidmarin.nutritionalplan.views.mainView


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.yesidmarin.nutritionalplan.R
import com.example.yesidmarin.nutritionalplan.data.model.EmployeeModel
import com.example.yesidmarin.nutritionalplan.utility.RUtil
import com.example.yesidmarin.nutritionalplan.utility.SharedPreferencesUtil
import com.example.yesidmarin.nutritionalplan.utility.Utility
import com.example.yesidmarin.nutritionalplan.views.employeesView.EmployeeViewActivity
import com.example.yesidmarin.nutritionalplan.views.nutritionalPlanView.NutritionalPlanView
import kotlinx.android.synthetic.main.activity_plan.*


class NutritionalActivity : AppCompatActivity() {

    private lateinit var nutritionalPlanViewModel: NutritionalPlanViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan)

        setupModel()
        setupView()
    }


    private fun setupModel() {

        nutritionalPlanViewModel = ViewModelProviders.of(this).get(NutritionalPlanViewModel::class.java)
        nutritionalPlanViewModel.employee.observe(this,Observer<EmployeeModel>{
            Utility.showToast(this,"Result: id ${it.id} \n name ${it.employeeName} \n age ${it.employeeAge} \n salary ${it.employeeSalary}")
        })
    }

    private fun setupView(){
        
        title = "Example MVVM"
        btAddNewPlan.setOnClickListener {
            val name: String = tvPlanNutritional.text.toString()
            val numberId: String = tvNumberId.text.toString()
            if (!name.isEmpty() && !numberId.isEmpty()){
                if (nutritionalPlanViewModel.addNewNutritionalPlan(name,numberId) ?: false){
                    Utility.showToast(this,"Add success")
                } else {
                    Utility.showToast(this,"Registration already exists with that id.")
                }
            } else {
                Utility.showToast(this,"Empty fields")
            }
        }
        btShowRegister.setOnClickListener{
            val startedRecycleViewActivity = Intent(this, NutritionalPlanView::class.java)
            startActivity(startedRecycleViewActivity)
        }

        btshowInService.setOnClickListener {
            val statedEmleoyeeViewsActivity = Intent(this, EmployeeViewActivity::class.java)
            startActivity(statedEmleoyeeViewsActivity)
        }

        btnSearch.setOnClickListener {
            val numberId: String = etSearchNumber.text.toString()
            if (!numberId.isEmpty()){
                nutritionalPlanViewModel.getEmployee(numberId)
            } else {
                Utility.showToast(this,"Empty fields")
            }
        }

        btShowPreferenceSaved.setOnClickListener {
            val typeUser = SharedPreferencesUtil.getPreference(RUtil.R_string(R.string.shared_key_userType), String::class.java)
            Utility.showToast(this, typeUser)
        }


    }

}
