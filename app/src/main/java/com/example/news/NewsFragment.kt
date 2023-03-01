package com.example.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.razzaghimahdi78.dotsloading.linear.LoadingBiggy

class NewsFragment : Fragment(R.layout.news_fragment) {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsRVAdapter
    lateinit var category: String
    lateinit var loadingIcon: LoadingBiggy
    lateinit var reloadButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getString("category", "")
        }


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadingIcon = view.findViewById(R.id.loadingIcon)
        reloadButton = view.findViewById(R.id.reloadButton)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = NewsRVAdapter(ArrayList<News>())
        recyclerView.adapter = adapter

        getData()

        reloadButton.setOnClickListener{
            getData()
        }
    }


    fun getData(){
        loadingIcon.visibility = View.VISIBLE
        reloadButton.visibility = View.GONE
        Networking.fetchData(category, requireContext(), object : Networking.NewsFetchListener {
            override fun onNewsFetched(newsList: ArrayList<News>) {
                adapter.updateList(newsList)
                loadingIcon.visibility = View.GONE
            }

            override fun onError() {
                loadingIcon.visibility = View.GONE
                reloadButton.visibility = View.VISIBLE


            }


        })
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

}