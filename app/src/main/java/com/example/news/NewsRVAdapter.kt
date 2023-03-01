package com.example.news

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsRVAdapter(private val arrayList:ArrayList<News>,val listener: RecyclerViewItemListener) : RecyclerView.Adapter<NewsRVAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        val viewHolder = MyViewHolder(view)
        view.setOnClickListener{
            listener.onItemClick(viewHolder.adapterPosition)
        }
        return viewHolder
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = arrayList[position].title
        holder.description.text = arrayList[position].desc
        holder.time.text = arrayList[position].time
        holder.source.text = arrayList[position].source

        val imageUrl = arrayList[position].imageUrl

        if (imageUrl != "null") {
            if (imageUrl.contains("youtube.com")) {
                // Get the video ID from the URL
                val videoId = imageUrl.substring(imageUrl.lastIndexOf("/") + 1)
                // Construct the thumbnail URL
                val thumbnailUrl = "https://img.youtube.com/vi/$videoId/0.jpg"
                Glide.with(holder.itemView.context).load(thumbnailUrl).into(holder.image)
            } else {

                Glide.with(holder.itemView.context).load(imageUrl).into(holder.image)
            }
        } else {
            holder.image.visibility = View.GONE

        }

    }
    fun updateList(list : ArrayList<News>){
        arrayList.clear()
        arrayList.addAll(list)
        notifyDataSetChanged()
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var description = itemView.findViewById<TextView>(R.id.desc)
        val image = itemView.findViewById<ImageView>(R.id.newsImage)
        var time = itemView.findViewById<TextView>(R.id.date)
        var source = itemView.findViewById<TextView>(R.id.source)
    }
}