package com.akash.assignment.utilities

import com.akash.assignment.m.StoriesModel
import com.akash.assignment.model.Hit
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/v1/search_by_date")
     fun getTopics(@Query("page") page:Int): Call<StoriesModel>
}