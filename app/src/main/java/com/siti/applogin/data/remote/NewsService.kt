package com.siti.applogin.data.remote

import com.siti.applogin.data.model.NewsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("/native/tourism")
    fun listNews() : Call<NewsList>

    @GET("/native/tourism")
    fun detailNews(@Query("url") url: String) : Call<NewsList>

    @GET("/native/tourism")
    fun searchNews(@Query("q") url : String) : Call<NewsList>
}