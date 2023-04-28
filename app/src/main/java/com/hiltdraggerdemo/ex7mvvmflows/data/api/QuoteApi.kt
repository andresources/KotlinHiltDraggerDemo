package com.hiltdraggerdemo.ex7mvvmflows.data.api

import com.hiltdraggerdemo.ex7mvvmflows.data.model.Quote
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApi {
    @GET(".")
    suspend fun getQuotes(): Response<Quote>
}