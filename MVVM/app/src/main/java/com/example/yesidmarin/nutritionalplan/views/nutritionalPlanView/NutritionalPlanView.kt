package com.example.yesidmarin.nutritionalplan.views.nutritionalPlanView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yesidmarin.nutritionalplan.R
import com.example.yesidmarin.nutritionalplan.utility.Utility
import com.example.yesidmarin.nutritionalplan.views.mainView.NutritionalPlanViewModel
import kotlinx.android.synthetic.main.activity_recycle_view.*


interface NutritionalInteraction{

    fun showToast(context: Context, msn: String) {
        Utility().showToast(context, msn)
    }
}

class NutritionalPlanView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)


        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        recycleView.layoutManager = layoutManager
        recycleView.setHasFixedSize(true)

        val nutritionalPlanViewModel = ViewModelProviders.of(this).get(NutritionalPlanViewModel::class.java)
        nutritionalPlanViewModel.queryNutritionalPlan().observe(this, Observer<List<String>>{
            recycleView.adapter = NutritionalViewAdapter(it)
        })

    }
}
