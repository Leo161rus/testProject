package com.example.testproject.ui.base

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.Interface.ItemClickListener
import com.example.testproject.R
import com.example.testproject.model.Category
import com.example.testproject.ui.main.ListNews
import java.util.*

class ListCategoryAdapter (private val context: Context,
                           private val category: Category): RecyclerView.Adapter<ListCategoryViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.source_news_layout,parent,false)
        return ListCategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return category.listCategory!!.size
    }

    override fun onBindViewHolder(holder: ListCategoryViewHolder, position: Int) {
        holder.categoryTitle.text = category.listCategory!![position].getNameSource()

        holder.setItemClickListener(object : ItemClickListener{

            override fun onClick(view: View, position: Int) {
                val intent = Intent(context, ListNews :: class.java)
                intent.putExtra("category", category.listCategory!![position].getIdSource())
                context.startActivity(intent)
            }


        })
    }
}