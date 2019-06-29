package com.example.dbsample.data

class CarRepository private constructor(private val carDao: CarDao) {

    fun getCars() = carDao.getCars()

    fun getCar(carId: String) = carDao.getCar(carId)

    fun insertCar(car: Car) = carDao.insertCar(car)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: CarRepository? = null

        fun getInstance(carDao: CarDao) =
            instance ?: synchronized(this) {
                instance ?: CarRepository(carDao).also { instance = it }
            }
    }
}
