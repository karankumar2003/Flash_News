package com.example.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout

class NewsFragment : Fragment(R.layout.fragment) {
    lateinit var recyclerView: RecyclerView
    lateinit var tabLayout: TabLayout
    lateinit var adapter: NewsAdapter
    lateinit var fragment: NewsFragment


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = (1..100).toList()
        fragment = this

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = NewsAdapter(list)
        recyclerView.adapter = adapter
    }

}

