package com.armin.hw15_1_city.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.armin.hw15_1_city.data.CityData
import com.armin.hw15_1_city.data.model.City

class ViewModelCity : ViewModel() {
    val citys = MutableLiveData<List<City>>().apply {
        value = CityData.cityList()
    }

    val selectedCity = MutableLiveData<List<City>>().apply {
        value = citys.value?.filter {
            it.selected
        }
    }
}