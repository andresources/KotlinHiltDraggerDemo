package com.hiltdraggerdemo.ex7mvvmflows.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.hiltdraggerdemo.Ex2_MyViewModel
import com.hiltdraggerdemo.R
import com.hiltdraggerdemo.ex7mvvmflows.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_ex7_main.*
@AndroidEntryPoint
class Ex7_MainActivity : AppCompatActivity() {
    private val myViewModel: QuoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex7_main)
        myViewModel.getQuote()
        lifecycleScope.launchWhenStarted {
            myViewModel.flowData.collect{
                    value: QuoteViewModel.QuotesEvent ->
                when(value){

                    is QuoteViewModel.QuotesEvent.Success ->{
                        progressBar.visibility = View.GONE
                        kanyeWestQuote.setText(value.resultText)
                    }
                    is QuoteViewModel.QuotesEvent.Failure -> {
                        progressBar.visibility =View.GONE
                        kanyeWestQuote.setText(value.errorText)
                    }
                    is QuoteViewModel.QuotesEvent.Loading -> {
                        progressBar.visibility =View.VISIBLE
                    }
                    else -> {}
                }
            }
        }
    }
}