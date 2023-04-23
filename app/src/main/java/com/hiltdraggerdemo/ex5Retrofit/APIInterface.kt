package com.hiltdraggerdemo.ex5Retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("Test/newUserRegister.php")
    fun reguser(@Query("user_name") user_name :String , @Query("User_password") User_password :String ) : Call<ResponceData>
}