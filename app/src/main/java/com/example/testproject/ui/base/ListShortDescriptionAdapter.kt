package com.example.testproject.ui.base

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.Common.ISO8601Parser
import com.example.testproject.Interface.ItemClickListener
import com.example.testproject.R
import com.example.testproject.model.DetailShort
import com.example.testproject.ui.main.NewsDetail
import io.reactivex.Flowable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.ParseException
import java.util.*


class ListShortDescriptionAdapter(var listShortDetail: List<DetailShort>,
                                  private val context: Context) : RecyclerView.Adapter<ListShortDescriptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListShortDescriptionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.news_layout,parent,false)
        return ListShortDescriptionViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listShortDetail.size
    }

    override fun onBindViewHolder(holder: ListShortDescriptionViewHolder, position: Int) {
        if (listShortDetail[position].getTitleForDetailShort().length > 65) {
            holder.shortDescription.text = listShortDetail[position].getTitleForDetailShort().substring(0, 65) + "..."
        } else {
            holder.shortDescription.text = listShortDetail[position].getTitleForDetailShort()
        }

        holder.title.text = listShortDetail[position].getTitleForDetailShort()

        var date: Date? = null
        try {
            date = ISO8601Parser.parse(listShortDetail[position].getDateForDetailShort())
        } catch (ex: ParseException) {
            ex.printStackTrace()
        }
        holder.date.setReferenceTime(date!!.time)

        holder.setItemClickListener(object : ItemClickListener {
            override fun onClick(view: View, position: Int) {
                val detail  = Intent(context, NewsDetail :: class.java)
                detail.putExtra("id", listShortDetail[position].getIdForDetailShort())
                context.startActivity(detail)
            }

    })
}

}