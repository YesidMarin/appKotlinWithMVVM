package com.example.yesidmarin.nutritionalplan.data.repository

import com.example.yesidmarin.nutritionalplan.data.dto.EmpleoyeeDTO
import com.example.yesidmarin.nutritionalplan.network.APiFactory
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

class EmpleoyeeRepository {
     fun getEmpleoyees(): Observable<MutableList<EmpleoyeeDTO>>? {
        return APiFactory.build()?.getEmpleoyees()
    }
}