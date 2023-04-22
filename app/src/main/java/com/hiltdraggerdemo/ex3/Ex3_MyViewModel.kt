package com.hiltdraggerdemo.ex3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class Ex3_MyViewModel @Inject constructor (@Named("secondcar") car:Car) : ViewModel() {
    private val myliveData = MutableLiveData<String>()
    init {
        myliveData.value = car.carName
    }
    fun getData() = myliveData
}