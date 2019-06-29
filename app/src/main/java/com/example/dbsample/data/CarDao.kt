package com.example.dbsample.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * The Data Access Object for the Plant class.
 */
@Dao
interface CarDao {
    @Query("SELECT * FROM cars ORDER BY name")
    fun getCars(): LiveData<List<Car>>

    @Query("SELECT * FROM cars WHERE id = :carId")
    fun getCar(carId: String): LiveData<Car>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCar(car: Car)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cars: List<Car>)

    @Update
    fun updateCar(car: Car)

    @Delete
    fun deleteCar(car: Car)
}