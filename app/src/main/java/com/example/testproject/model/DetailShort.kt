package com.example.testproject.model

class DetailShort {
    private var id: Long = 0
    private lateinit var shortDescription : String
    private lateinit var title: String
    private lateinit var date: String

    fun setIdForDetailShort(id: Long){
        this.id = id
    }

    fun getIdForDetailShort() : Long{
        return id
    }

    fun setShortDescription(fullDescription: String){
        this.shortDescription = fullDescription
    }

    fun getShortDescription() : String{
        return shortDescription
    }

    fun getDateForDetailShort() : String{
        return date
    }

    fun setDateForDetailShort(date : String){
        this.date = date
    }

    fun getTitleForDetailShort() : String{
        return title
    }

    fun setTitleForDetailShort(title : String){
        this.title = title
    }
}