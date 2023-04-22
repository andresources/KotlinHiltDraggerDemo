package com.hiltdraggerdemo.ex3

import android.content.Context
import com.hiltdraggerdemo.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CarModule {
    @Provides
    @Singleton
    @Named("firstcar")
    fun providesCarFirst() : Car{
        return Car("BMW")
    }

    @Provides
    @Singleton
    @Named("secondcar")
    fun providesCarSecond(@ApplicationContext context:Context) : Car{
        return Car(context.resources.getString(R.string.car_name))
    }
}