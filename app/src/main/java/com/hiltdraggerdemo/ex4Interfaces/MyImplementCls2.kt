package com.hiltdraggerdemo.ex4Interfaces

import javax.inject.Inject

class MyImplementCls2 @Inject constructor(): MyInterface {
    override fun getName() = "2.This is MyImplementation Class2"
}