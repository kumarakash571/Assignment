package com.akash.assignment.utilities

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {
    var base_url = "https://hn.algolia.com/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}