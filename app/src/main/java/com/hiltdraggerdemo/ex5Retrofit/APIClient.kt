package com.hiltdraggerdemo.ex5Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object{
        private lateinit var retrofit: Retrofit
        fun getClient() : Retrofit{
            retrofit = Retrofit.Builder().baseUrl("https://freegreetingsadda.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }
    }
}