package com.example.testproject.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testproject.Network.NewsService
import com.example.testproject.R
import com.example.testproject.model.Detail
import com.example.testproject.model.DetailShort
import com.example.testproject.model.News
import com.example.testproject.ui.base.ListShortDescriptionAdapter
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.activity_list_news.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ListNews : AppCompatActivity() {

    private var id = -1
    lateinit var adapter: ListShortDescriptionAdapter
    lateinit var  mService : NewsService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_news)

        mService = NewsService.create()

        listNews.layoutManager = LinearLayoutManager(this)

        if(intent != null){
            id = intent.getIntExtra("category", id)
            if(id != -1){
                loadNews(id.toLong(),true)
            }
        }
    }

    private fun loadNews(id : Long, isRefreshed : Boolean){
        if (isRefreshed){
            mService.searchListNews(id,0)
                .enqueue(object : retrofit2.Callback<News> {
                    override fun onResponse(call: Call<News>, response: Response<News>) {
                        topTitle.text = response.body()!!.listNews!![0].getTitleForDetailShort()

                        val removeFirstItem = response.body()!!.listNews
                        removeFirstItem!!.removeAt(0)

                        adapter = ListShortDescriptionAdapter(removeFirstItem,baseContext)
                        adapter.notifyDataSetChanged()
                        listNews.adapter = adapter
                    }

                    override fun onFailure(call: Call<News>, t: Throwable) {

                    }
                })
        }
    }
}