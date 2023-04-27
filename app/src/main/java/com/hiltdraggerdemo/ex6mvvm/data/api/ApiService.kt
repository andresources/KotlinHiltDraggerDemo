package com.hiltdraggerdemo.ex6mvvm.data.api
import com.hiltdraggerdemo.ex6mvvm.data.model.User
import retrofit2.Response
import retrofit2.http.GET
interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}