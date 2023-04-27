package com.hiltdraggerdemo.ex6mvvm.data.api

import com.hiltdraggerdemo.ex6mvvm.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override suspend fun getUsers() = apiService.getUsers()
}