package com.example.dbsample.utilities

import android.content.Context
import com.example.dbsample.data.AppDatabase
import com.example.dbsample.data.CarRepository
import com.example.dbsample.viewmodels.CarListViewModelFactory

object InjectorUtils {
    private fun getCarRepository (context: Context) : CarRepository {
        return CarRepository.getInstance(AppDatabase.getInstance(context.applicationContext).CarDao())
    }

    fun provideCarListViewModelFactory (context : Context) : CarListViewModelFactory {
        return CarListViewModelFactory(getCarRepository(context))

    }
}