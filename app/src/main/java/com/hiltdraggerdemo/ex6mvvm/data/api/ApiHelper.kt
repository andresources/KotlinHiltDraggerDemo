package com.hiltdraggerdemo.ex6mvvm.data.api

import com.hiltdraggerdemo.ex6mvvm.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}