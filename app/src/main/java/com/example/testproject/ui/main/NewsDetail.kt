package com.example.testproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testproject.Network.NewsService
import com.example.testproject.R
import com.example.testproject.model.SIngleDetail
import kotlinx.android.synthetic.main.activity_news_detail.*
import retrofit2.Call
import retrofit2.Response

class NewsDetail : AppCompatActivity() {
    lateinit var  mService : NewsService
    private var id  = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        mService = NewsService.create()

        if(intent != null){
            id = intent.getIntExtra("id",id)
            if(id != -1){
                loadNews(id.toLong(),true)
            }
        }
    }

    private fun loadNews(id : Long, isRefreshed : Boolean){
        if (isRefreshed){
            mService.searchDetails(id)
                .enqueue(object : retrofit2.Callback<SIngleDetail> {
                    override fun onFailure(call: Call<SIngleDetail>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<SIngleDetail>, response: Response<SIngleDetail>) {
                        titleDetail.text = response.body()!!.listDetail!![0].getTitle()
                        fullDescriptionDetail.text = response.body()!!.listDetail!![0].getFullDescription()
                        dateDetail.text = response.body()!!.listDetail!![0].getDate()

                    }

                })
        }
    }
}