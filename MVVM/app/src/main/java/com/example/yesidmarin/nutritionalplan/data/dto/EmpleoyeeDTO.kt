package com.example.yesidmarin.nutritionalplan.data.dto

import com.google.gson.annotations.SerializedName

class EmpleoyeeDTO{

    @SerializedName("id")
    var id: String? = null
    @SerializedName("employee_name")
    var employeeName: String? = null
    @SerializedName("empleoyee_salary")
    var empleoyeeSalary: String? = null
    @SerializedName("empleoyee_age")
    var empleoyeeAge: String? = null
    @SerializedName("profile_image")
    var profile_image: String? = null
}