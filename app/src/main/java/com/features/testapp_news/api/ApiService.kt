package com.features.testapp_news.api

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/")
    fun getNews() : Call<ArrayList<NewsModel>>
}