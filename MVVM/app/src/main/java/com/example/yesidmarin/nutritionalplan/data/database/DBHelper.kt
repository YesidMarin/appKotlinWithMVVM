package com.example.yesidmarin.nutritionalplan.data.database

import io.realm.Realm
import io.realm.RealmModel

enum class DBHelperOptions {
    insertRow,
    insertRows,
    updateRow,
    deleteRow,
    deleteAllTable
}

class DBHelperResponse {
    var status: Boolean = false
    var totalRows: Int = 0
    var identfier: String? = null
    var operation: DBHelperOptions? = null
}

class DBHelper {

    var realm: Realm? = null

    init {
        realm = Realm.getDefaultInstance()
    }

    fun build(): DBHelper {
        realm = Realm.getDefaultInstance()
        return this
    }

    fun <T: RealmModel?>insertRow(item: T){
        realm?.beginTransaction()
        realm?.insertOrUpdate(item)
        realm?.commitTransaction()
        close()
    }

    fun close(){
        realm?.let {
            if (!it.isClosed){
                it.close()
            }
        }
    }

}