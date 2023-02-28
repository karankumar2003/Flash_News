package com.example.news

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsRVAdapter(private val arrayList:ArrayList<News>) : RecyclerView.Adapter<NewsRVAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = arrayList[position].title
        holder.description.text = arrayList[position].desc
        holder.time.text = arrayList[position].time
        holder.source.text = arrayList[position].source

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var description = itemView.findViewById<TextView>(R.id.desc)
        val image = itemView.findViewById<ImageView>(R.id.newsImage)
        var time = itemView.findViewById<TextView>(R.id.date)
        var source = itemView.findViewById<TextView>(R.id.source)
    }
}