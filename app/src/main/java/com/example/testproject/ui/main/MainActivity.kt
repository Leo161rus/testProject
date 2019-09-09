package com.example.testproject.ui.main


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testproject.Network.NewsService
import com.example.testproject.R
import com.example.testproject.model.Category
import com.example.testproject.ui.base.ListCategoryAdapter
import com.google.gson.Gson
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.xml.transform.Source

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var mService : NewsService
    lateinit var adapter: ListCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = NewsService.create()

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        loadWebSiteSource(true)
    }

    private fun loadWebSiteSource(isRefreshed: Boolean) {
        if (!isRefreshed){

            mService.searchCategory().enqueue(object : Callback<Category>{
                override fun onFailure(call: Call<Category>, t: Throwable) {

                }

                override fun onResponse(call: Call<Category>, response: Response<Category>) {
                    adapter = ListCategoryAdapter(baseContext,response.body()!!)
                    adapter.notifyDataSetChanged()
                    recyclerView.adapter = adapter
                }
            })
        }
    }
}
