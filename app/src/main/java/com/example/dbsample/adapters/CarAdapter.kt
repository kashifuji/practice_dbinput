package com.example.dbsample.adapters

import android.content.ContentValues
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dbsample.data.Car
import com.example.dbsample.databinding.ListItemCarBinding

class CarAdapter : ListAdapter<Car, CarAdapter.ViewHolder>(CarDiffCallBack()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val car = getItem(position)
        holder.apply {
            bind(createOnClickListener(car), car)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemCarBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(car: Car): View.OnClickListener {
        return View.OnClickListener {
            Log.v(ContentValues.TAG, "click : " + car.toString())
        }
    }

    class ViewHolder(private val binding: ListItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(listener: View.OnClickListener, item: Car) {
            binding.apply {
                clickListener = listener
                car = item
                executePendingBindings()
            }
        }

    }
//    class ViewHolder(
//        private val binding: ListItemPlantBinding
//    ) : RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(listener: View.OnClickListener, item: Plant) {
//            binding.apply {
//                clickListener = listener
//                plant = item
//                executePendingBindings()
//            }
//        }
//    }
}

private class CarDiffCallBack : DiffUtil.ItemCallback<Car> () {
    override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem.carId == newItem.carId
    }

    override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem == newItem
    }

}