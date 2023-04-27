package com.hiltdraggerdemo.ex5Retrofit

import com.hiltdraggerdemo.Student
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    /*@Provides
    @Singleton
    fun provideRetrofit() :Retrofit{
        return APIClient.getClient()
    }*/
}