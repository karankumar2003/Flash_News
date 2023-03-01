package com.example.news

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.razzaghimahdi78.dotsloading.linear.LoadingBiggy

class NewsFragment : Fragment(R.layout.news_fragment) {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NewsRVAdapter
    lateinit var category: String
    lateinit var loadingIcon: LoadingBiggy
    lateinit var reloadButton: Button
    lateinit var internetStatusTextView : TextView


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
        internetStatusTextView = view.findViewById(R.id.internetStatusTextView)

        adapter = NewsRVAdapter(ArrayList<News>())
        recyclerView.adapter = adapter

        checkInternetConnection()
        getData()

        reloadButton.setOnClickListener{

            checkInternetConnection()
            getData()
            checkInternetConnection()
        }
    }


    private fun getData(){
        internetStatusTextView.visibility = View.GONE
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

    private fun checkInternetConnection(){

        val connectivityManager : ConnectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if(connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)==null){
            recyclerView.visibility = View.GONE
            internetStatusTextView.visibility = View.VISIBLE
            internetStatusTextView.text = "No Internet Connection!"
            reloadButton.visibility = View.VISIBLE

        }



}}