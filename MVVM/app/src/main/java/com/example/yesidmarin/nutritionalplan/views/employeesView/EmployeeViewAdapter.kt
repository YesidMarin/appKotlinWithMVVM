package com.example.yesidmarin.nutritionalplan.views.employeesView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yesidmarin.nutritionalplan.R
import com.example.yesidmarin.nutritionalplan.data.model.EmployeeModel
import kotlinx.android.synthetic.main.list_item.view.*

class EmployeeViewAdapter(var data: List<EmployeeModel>): RecyclerView.Adapter<EmployeeViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val plan = data[position]
        holder.setData(plan)

    }

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var currentPlan: EmployeeModel? = null

        fun setData(plan: EmployeeModel){
            itemView.tvTitle.text = plan.employeeName
            this.currentPlan = plan
        }
    }

}