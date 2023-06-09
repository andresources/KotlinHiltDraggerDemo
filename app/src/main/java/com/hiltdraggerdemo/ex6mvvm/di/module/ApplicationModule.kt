package com.hiltdraggerdemo.ex6mvvm.di.module


import com.hiltdraggerdemo.BuildConfig
import com.hiltdraggerdemo.BuildConfig.BASE_URL
import com.hiltdraggerdemo.ex6mvvm.data.api.ApiHelper
import com.hiltdraggerdemo.ex6mvvm.data.api.ApiHelperImpl
import com.hiltdraggerdemo.ex6mvvm.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() =  if (BuildConfig.DEBUG){
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        } else {
            OkHttpClient
                .Builder()
                .build()
    }

    @Provides
    @Singleton
    @Named("retro2")
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL :String) : Retrofit =
         Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(@Named("retro2") retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper


}