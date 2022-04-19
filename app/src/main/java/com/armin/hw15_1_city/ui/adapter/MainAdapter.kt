package com.armin.hw15_1_city.ui.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.armin.hw15_1_city.data.model.City
import com.armin.hw15_1_city.databinding.ItemLayoutBinding

class MainAdapter: ListAdapter<City, MainAdapter.CityViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    class CityViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(city: City) {
            binding.apply {
                checkOnSelectedCity.isVisible = city.selected
                cityNameTextView.text = city.name
                itemList.setOnClickListener {
                    if (city.selected == true) {
                        city.selected = false
                        checkOnSelectedCity.isVisible = false
                    } else {
                        city.selected = true
                        checkOnSelectedCity.isVisible = true
                    }
                }

            }
        }

    }
}

class DiffCallback : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: City, newItem: City) =
        oldItem == newItem


}