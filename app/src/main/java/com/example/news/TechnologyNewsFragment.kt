package com.example.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TechnologyNewsFragment : Fragment(R.layout.news_fragment) {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsRVAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)


        adapter = NewsRVAdapter(Networking.fetchData("technology", requireContext()))
        recyclerView.adapter = adapter
    }

}

