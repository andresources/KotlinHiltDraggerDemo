package com.hiltdraggerdemo.ex7mvvmflows.data.repositry

import com.hiltdraggerdemo.ex7mvvmflows.data.api.QuoteApi
import com.hiltdraggerdemo.ex7mvvmflows.data.model.Quote
import com.hiltdraggerdemo.ex7mvvmflows.data.utils.Resource
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(val quoteApi: QuoteApi) : MainRepository {
    override suspend fun getQuotes(): Resource<Quote> {
        return try {
            val response = quoteApi.getQuotes()
            val result = response.body()
            if (response.isSuccessful && result != null){
                Resource.Success(result)
            }else{
                Resource.Error("An Error occurred")
            }
        }catch (e:Exception){
            println("kanyeWestApi $e")
            Resource.Error("An $e occurred")
        }
    }
}