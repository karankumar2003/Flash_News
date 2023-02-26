package com.example.news

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fragment2 : Fragment(R.layout.fragment1) {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsRVAdapter
    lateinit var fragment: fragment2


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = (100..200).toList()


        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        adapter = NewsRVAdapter(list)
        recyclerView.adapter = adapter
    }

}

