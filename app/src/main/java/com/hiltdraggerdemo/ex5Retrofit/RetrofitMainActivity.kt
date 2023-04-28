package com.hiltdraggerdemo.ex5Retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hiltdraggerdemo.R
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class RetrofitMainActivity : AppCompatActivity() {
    @Inject @Named("retro1") lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_main)
        val apiC: APIInterface =retrofit.create(APIInterface::class.java)
        var obj:Call<ResponceData> =apiC.reguser("test","tst")
        obj.enqueue(object : Callback<ResponceData>{
            override fun onResponse(call: Call<ResponceData>?, response: Response<ResponceData>?) {
               Toast.makeText(applicationContext,response?.body()?.message,Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<ResponceData>?, t: Throwable?) {

            }
        })
    }
}