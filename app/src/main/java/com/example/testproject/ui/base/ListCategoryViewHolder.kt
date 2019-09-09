package com.example.testproject.ui.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.Interface.ItemClickListener
import kotlinx.android.synthetic.main.source_news_layout.view.*

class ListCategoryViewHolder(itemView : View) : RecyclerView.ViewHolder (itemView), View.OnClickListener{

    private lateinit var itemClickListener: ItemClickListener

    var categoryTitle = itemView.sourceNewsName


    init{
        itemView.setOnClickListener(this)
    }

    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        itemClickListener.onClick(v!!,adapterPosition)
    }
}