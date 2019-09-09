package com.example.testproject.model

class Detail {
    private var id: Long = 0
    private lateinit var fullDescription : String
    private lateinit var title: String
    private lateinit var date: String

    fun setId(id: Long){
    this.id = id
    }

    fun getId() : Long{
    return id
    }

    fun setFullDescription(fullDescription: String){
    this.fullDescription = fullDescription
    }

    fun getFullDescription() : String{
    return fullDescription
    }

    fun getDate() : String{
    return date
    }

    fun setDate(date : String){
    this.date = date
    }

    fun getTitle() : String{
    return title
    }

    fun setTitle(title : String){
    this.title = title
    }
}