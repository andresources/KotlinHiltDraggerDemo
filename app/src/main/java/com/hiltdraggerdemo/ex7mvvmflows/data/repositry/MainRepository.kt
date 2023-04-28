package com.hiltdraggerdemo.ex7mvvmflows.data.repositry

import com.hiltdraggerdemo.ex7mvvmflows.data.model.Quote
import com.hiltdraggerdemo.ex7mvvmflows.data.utils.Resource

interface MainRepository {
    suspend fun getQuotes(): Resource<Quote>
}