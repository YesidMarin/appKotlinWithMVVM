package com.example.yesidmarin.nutritionalplan.views.nutritionalPlanView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yesidmarin.nutritionalplan.R
import kotlinx.android.synthetic.main.list_item.view.*

class NutritionalViewAdapter(var data: List<String>): RecyclerView.Adapter<NutritionalViewAdapter.MyViewHolder>(), NutritionalInteraction{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return  MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val plan = data[position]
        holder.setData(plan)
    }

    inner class MyViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew){

        private var currentPlan: String? = null
        private var recycleInteraction = NutritionalViewAdapter(data)

        init {
            itemVIew.setOnClickListener {
                recycleInteraction.showToast(itemVIew.context,"$currentPlan Clicked!!")
            }
        }

        fun setData(plan: String){
            itemView.tvTitle.text = plan
            this.currentPlan = plan
        }
    }
}