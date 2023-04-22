package com.hiltdraggerdemo.ex4Interfaces

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
interface MyModule {
    @Binds
    @MyFirstClass
    fun provideMyFirstClass(cls1: MyImplementCls1): MyInterface

    @Binds
    @MySecondClass
    fun provideMySeconndClass(cls2: MyImplementCls2): MyInterface
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MyFirstClass

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MySecondClass