package com.hiltdraggerdemo.ex4Interfaces

import javax.inject.Inject

class MyImplementCls1 @Inject constructor(): MyInterface {
    override fun getName() = "1.This is MyImplementation Class1"
}