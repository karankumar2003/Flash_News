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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)


        adapter = NewsRVAdapter(Networking.fetchData("top", requireContext()))
        recyclerView.adapter = adapter
    }
    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged() // update the adapter when the fragment is resumed
    }
}

