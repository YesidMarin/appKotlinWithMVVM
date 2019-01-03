package com.example.yesidmarin.nutritionalplan.data.repository

import com.example.yesidmarin.nutritionalplan.data.dto.EmployeeDTO
import com.example.yesidmarin.nutritionalplan.network.APiFactory
import io.reactivex.Observable

class EmployeeRepository {
     fun getAllEmployees(): Observable<MutableList<EmployeeDTO>>? {
        return APiFactory.build()?.getAllEmployees()
    }

    fun getEmployee(id: String): Observable<EmployeeDTO>?{
        return APiFactory.build()?.getEmployee(id)
    }

}