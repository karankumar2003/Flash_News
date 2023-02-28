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

    val newsList = arrayListOf(
        News(
            "Headline 1",
            "This is the first news headline.",
            "https://example.com/image1.jpg",
            "2022-02-28 10:00:00",
            "Example News Source 1",
            "https://example.com/article/1"
        ),
        News(
            "Headline 2",
            "This is the second news headline.",
            "https://example.com/image2.jpg",
            "2022-02-27 15:30:00",
            "Example News Source 2",
            "https://example.com/article/2"
        ),
        News(
            "Headline 3",
            "This is the third news headline.",
            "https://example.com/image3.jpg",
            "2022-02-27 12:00:00",
            "Example News Source 3",
            "https://example.com/article/3"
        )
    )


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

            adapter = NewsRVAdapter(newsList)
//        adapter = NewsRVAdapter(Networking.fetchData(category, requireContext()))
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