package com.example.yesidmarin.nutritionalplan.network

import com.example.yesidmarin.nutritionalplan.data.dto.EmployeeDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface Services {
    @GET("api/v1/employees")
    fun getAllEmployees():  Observable<MutableList<EmployeeDTO>>

    @GET("api/v1/employee/{id}")
    fun getEmployee(@Path("id") id: String): Observable<EmployeeDTO>

}