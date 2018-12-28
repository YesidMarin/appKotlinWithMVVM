package com.example.yesidmarin.nutritionalplan.network

import android.database.Observable
import retrofit2.http.GET

interface Services {
    @GET("api/v1/employees")
    fun getEmpleoyees(): Observable<List<Any>>
}