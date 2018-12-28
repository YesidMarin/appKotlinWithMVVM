package com.example.yesidmarin.nutritionalplan.data.repository

import com.example.yesidmarin.nutritionalplan.data.dto.EmpleoyeeDTO
import io.reactivex.Observable

interface IEmpleoyeeRepository {
    fun getEmpleoyees(): Observable<List<EmpleoyeeDTO>>?
}