package com.example.news

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONArray
import java.security.AccessController.getContext

class Networking {
    companion object {
        private const val baseUrl =
            "https://newsdata.io/api/1/news?apikey=pub_1722619c153aa6e11254c32f6e530ea14798d&language=en&country=in&category="

        fun fetchData(category: String, context: Context): ArrayList<News> {
            val newsList = ArrayList<News>()
            Log.d("Networking", "start")
            val url = baseUrl + category
            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                {
                    val results = it.getJSONArray("results")

                    for (i in 0 until results.length()) {
                        val article = results.getJSONObject(i)

                        val news = News(
                            article.getString("title"),
                            article.getString("description"),
                            article.getString("image_url"),
                            article.getString("pubDate"),
                            article.getString("source_id"),
                            article.getString("link")
                        )
                        newsList.add(news)
                    }
                }, {
                    val statusCode = it.networkResponse?.statusCode
                    Log.e("MainActivity", "Error - status code: $statusCode")
                })
            MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest)

            return newsList
        }

    }
}