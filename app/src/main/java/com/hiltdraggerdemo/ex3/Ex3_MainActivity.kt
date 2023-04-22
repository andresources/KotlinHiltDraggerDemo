package com.hiltdraggerdemo.ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.hiltdraggerdemo.Ex2_MyViewModel
import com.hiltdraggerdemo.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class Ex3_MainActivity : AppCompatActivity() {
    @Inject
    @Named("firstcar")
    lateinit var car : Car
    private val myViewModel: Ex3_MyViewModel by viewModels()
    private lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3_main1)
        tv = findViewById(R.id.tv)
        //tv.setText(car.carName)
        myViewModel.getData().observe(this,{
            tv.setText(car.carName + it)
        })
    }

}