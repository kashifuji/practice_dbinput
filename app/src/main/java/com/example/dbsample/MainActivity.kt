package com.example.dbsample

import android.content.ContentValues
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dbsample.data.AppDatabase
import com.example.dbsample.data.CarRepository
import android.content.Context
import android.util.Log
import com.example.dbsample.data.Car
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), CarListFragment.OnFragmentInteractionListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // CoroutineWorkerで動かす
        thread {
            val carRepository = CarRepository.getInstance(AppDatabase.getInstance(this.applicationContext).CarDao())
//        val carRepository = CarRepository.getInstance(AppDatabase.getInstance(context).CarDao())
            val car = Car("1","taxi", "simple", 10, "")
            carRepository.insertCar(car)

            val cars = carRepository.getCars()

        }

    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
