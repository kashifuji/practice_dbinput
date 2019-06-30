package com.example.dbsample.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dbsample.data.Car
import com.example.dbsample.data.CarRepository
import java.util.*
import kotlin.concurrent.thread

class CarListViewModel (private val carRepository: CarRepository) : ViewModel() {

    val cars: LiveData<List<Car>> = carRepository.getCars()

    fun addCar(name : String) {
        thread {
            val car = Car(UUID.randomUUID().toString(), name, "simple", 10, "")
            carRepository.insertCar(car)
        }
    }

}
