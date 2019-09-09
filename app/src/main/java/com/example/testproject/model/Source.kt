package com.example.testproject.model

import java.lang.NullPointerException

class Source {
    private var id : Long = 0
    private var name : String = ""

    fun getIdSource() : Long{
        return id
    }

    fun setIdSource(id : Long){
        this.id = id
    }

    fun getNameSource() : String{
        return name
    }
}