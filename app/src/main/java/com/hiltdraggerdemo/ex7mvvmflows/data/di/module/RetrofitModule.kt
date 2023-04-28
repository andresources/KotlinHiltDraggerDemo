package com.hiltdraggerdemo.ex7mvvmflows.data.di.module

import com.hiltdraggerdemo.ex7mvvmflows.data.api.QuoteApi
import com.hiltdraggerdemo.ex7mvvmflows.data.repositry.MainRepository
import com.hiltdraggerdemo.ex7mvvmflows.data.repositry.MainRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.kanye.rest/"

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Singleton
    @Provides
    fun provideQuoteApi() : QuoteApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApi::class.java)
    }
    @Singleton
    @Provides
    fun provideRepository(quoteApi: QuoteApi) : MainRepository = MainRepositoryImpl(quoteApi)

}