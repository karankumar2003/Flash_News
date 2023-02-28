package com.example.news

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.news.Networking.Companion.fetchData

class TopNewsFragment : Fragment(R.layout.news_fragment) {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsRVAdapter
    private var newsList = ArrayList<News>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // create a list of news objects
        val news1 = News("Title 1", "Description 1", "https://dummyimage.com/200x200/000/fff", "2022-01-01 10:00:00", "Source 1", "https://www.example.com/news/1")
        val news2 = News("Title 2", "Description 2", "https://dummyimage.com/200x200/000/fff", "2022-01-02 11:00:00", "Source 2", "https://www.example.com/news/2")
        val news3 = News("Title 3", "Description 3", "https://dummyimage.com/200x200/000/fff", "2022-01-03 12:00:00", "Source 3", "https://www.example.com/news/3")
        newsList.add(news1)
        newsList.add(news2)
        newsList.add(news3)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        // pass the list of news objects to the adapter
        adapter = NewsRVAdapter(newsList)
        recyclerView.adapter = adapter
    }
}

