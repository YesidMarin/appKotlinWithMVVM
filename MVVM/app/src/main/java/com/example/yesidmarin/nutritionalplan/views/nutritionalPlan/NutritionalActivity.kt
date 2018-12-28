package com.example.yesidmarin.nutritionalplan.views.nutritionalPlan


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.yesidmarin.nutritionalplan.R
import com.example.yesidmarin.nutritionalplan.data.dto.EmpleoyeeDTO
import com.example.yesidmarin.nutritionalplan.data.model.EmpleoyeeModel
import com.example.yesidmarin.nutritionalplan.utility.Utility
import com.example.yesidmarin.nutritionalplan.views.recycleView.RecycleViewActivity
import kotlinx.android.synthetic.main.activity_plan.*


class NutritionalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plan)
        setupActions()
    }

    private fun setupActions(){

        val nutritionalPlanViewModel = ViewModelProviders.of(this).get(NutritionalPlanViewModel::class.java)
        btAddNewPlan.setOnClickListener {
            val name: String = tvPlanNutritional.text.toString()
            val numberId: String = tvNumberId.text.toString()
            if (!name.isEmpty() && !numberId.isEmpty()){
                if (nutritionalPlanViewModel.addNewNutritionalPlan(name,numberId)){
                    Utility().showToast(this,"Add success")
                } else {
                    Utility().showToast(this,"Registration already exists with that id.")
                }
            } else {
                Utility().showToast(this,"Empty fields")
            }
        }
        btShowRegister.setOnClickListener{
            val startedRecycleViewActivity = Intent(this, RecycleViewActivity::class.java)
            startActivity(startedRecycleViewActivity)
        }

        var sd: MutableList<List<EmpleoyeeModel>> = ArrayList()
        btshowInService.setOnClickListener {
            Utility().showToast(this,"nothing data")
            nutritionalPlanViewModel.getEmpleoyees().observe(this, Observer<List<EmpleoyeeModel>>{
                sd.add(it)
            })
        }

    }

}
