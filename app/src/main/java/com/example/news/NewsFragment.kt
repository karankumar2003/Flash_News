package com.example.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewsFragment : Fragment(R.layout.news_fragment) {
    lateinit var recyclerView: RecyclerView


    lateinit var adapter: NewsRVAdapter
    lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getString("category", "")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)


        adapter = NewsRVAdapter(Networking.fetchData(category, requireContext()))
        recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance(category: String): NewsFragment {
            val instance = NewsFragment().apply {
                arguments = Bundle().apply {
                    putString("category", category)
                }
            }
            return instance
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}