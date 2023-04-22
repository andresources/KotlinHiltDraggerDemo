package com.hiltdraggerdemo.ex4Interfaces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import com.hiltdraggerdemo.R
import com.hiltdraggerdemo.ex3.Ex3_MyViewModel

class Ex4MainActivity : AppCompatActivity() {
    private val myViewModel: MyIViewModel by viewModels()
    private lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex3_main1)
        tv = findViewById(R.id.tv)
        tv.setText(myViewModel.getData())

    }
}