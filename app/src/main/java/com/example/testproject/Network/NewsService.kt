package com.example.testproject.Network

import android.app.usage.NetworkStatsManager
import com.example.testproject.model.*
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsService {

    @GET("/v1/news/categories")
    fun searchCategory() : Call<Category>

    @GET("/v1/news/categories/{id}/news")
    fun searchListNews(@Path("id") id : Long,
                       @Query("page") page : Int) : Call<News>

    @GET("/v1/news/details")
    fun searchDetails(@Query("id") id : Long) : Call<SIngleDetail>



    companion object Factory{
        fun create() : NewsService{
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://testtask.sebbia.com")
                .build()

            return retrofit.create(NewsService::class.java)
        }
    }
}