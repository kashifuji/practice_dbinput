package com.example.dbsample.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dbsample.data.CarRepository

class CarListViewModelFactory (private val repository: CarRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = CarListViewModel(repository) as T
}