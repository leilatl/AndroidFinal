package com.example.afinal

import retrofit2.Call
import retrofit2.http.*

interface ApiService {


    @GET("/category/{categoryName}/{countryName}/in.json")
    fun getArticles(@Path("categoryName") categoryName: String,
                @Path("countryName") countryName: String):
            Call<Json>


}