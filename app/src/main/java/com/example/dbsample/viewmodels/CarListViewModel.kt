package com.example.dbsample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dbsample.data.Car
import com.example.dbsample.data.CarRepository

class CarListViewModel internal constructor(carRepository: CarRepository) : ViewModel() {

//    val carRepository = CarRepository
    val cars: LiveData<List<Car>> = carRepository.getCars()

//    init {
//        carRepository
//
//    }
}
