package com.example.dbsample.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "cars")
data class Car(
    @PrimaryKey @ColumnInfo(name = "id") val carId: String,
    val name: String,
    val description: String,
    val size: Int,
    val imageUrl: String = ""
) {

    override fun toString() = name
}
