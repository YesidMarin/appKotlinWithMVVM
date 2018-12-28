package com.example.yesidmarin.nutritionalplan.views.recycleView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yesidmarin.nutritionalplan.R
import com.example.yesidmarin.nutritionalplan.utility.Utility
import com.example.yesidmarin.nutritionalplan.views.nutritionalPlan.NutritionalPlanViewModel
import kotlinx.android.synthetic.main.activity_recycle_view.*


interface RecycleInteraction{

    fun showToast(context: Context, msn: String) {
        Utility().showToast(context, msn)
    }
}

class RecycleViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)


        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recycleView.layoutManager = layoutManager
        recycleView.setHasFixedSize(true)

        val nutritionalPlanViewModel = ViewModelProviders.of(this).get(NutritionalPlanViewModel::class.java)
        nutritionalPlanViewModel.queryNutritionalPlan().observe(this, Observer<List<String>>{
            recycleView.adapter = RecycleViewAdapter(it)
        })

    }
}
