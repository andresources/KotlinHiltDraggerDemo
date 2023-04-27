package com.hiltdraggerdemo.ex6mvvm.data.repository

import com.hiltdraggerdemo.ex6mvvm.data.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    suspend fun getUsers() =  apiHelper.getUsers()
}