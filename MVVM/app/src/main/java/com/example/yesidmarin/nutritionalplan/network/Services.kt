package com.example.yesidmarin.nutritionalplan.network

import com.example.yesidmarin.nutritionalplan.data.dto.EmpleoyeeDTO
import io.reactivex.Observable
import retrofit2.http.GET

interface Services {
    @GET("api/v1/employees")
    fun getEmpleoyees():  Observable<MutableList<EmpleoyeeDTO>>
}