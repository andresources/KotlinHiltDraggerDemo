package com.hiltdraggerdemo.ex4Interfaces

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyIViewModel @Inject constructor(@MyFirstClass private val firstClass: MyInterface, @MySecondClass private val secondClass: MyInterface) : ViewModel(){
    fun getData() = firstClass.getName() + secondClass.getName()
}