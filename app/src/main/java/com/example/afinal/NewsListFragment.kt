package com.example.afinal

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_news_list.view.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NewsListFragment : Fragment() {
    val args: NewsListFragmentArgs by navArgs()

    var list = mutableListOf<Article>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)

        val adapter = Adapter()
        val recyclerView = view.toDoRecyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

       val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://saurav.tech/NewsAPI/top-headlines/")
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()
        val catName = args.category
        val countryName = args.country

        val apiService = retrofit.create(ApiService::class.java)
        apiService.getArticles(catName, countryName).enqueue(object : Callback<Json> {
            override fun onFailure(call: Call<Json>, t: Throwable) {
                Log.e("Error", t.message!!)
            }

            override fun onResponse(call: Call<Json>, response: Response<Json>) {
                Log.e("Response size: ", response.body()!!.articles.size.toString()+"")
                list.addAll(response.body()!!.articles)
                adapter.setData(list)
            }
        })


        return view
    }


}