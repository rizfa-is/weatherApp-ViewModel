package com.istekno.weatherappviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.istekno.weatherappviewmodel.api.WeatherAPI
import com.istekno.weatherappviewmodel.model.WeatherItems

class WeatherViewModel: ViewModel() {

    private lateinit var getWeatherAPI: WeatherAPI

    val listWeathers = MutableLiveData<ArrayList<WeatherItems>>()

    fun setWeather(cities: String, showLoading:() -> Unit) {
        getWeatherAPI = WeatherAPI()
        getWeatherAPI.setWeather(cities, listWeathers) { showLoading() }
    }

    fun getWeather() : LiveData<ArrayList<WeatherItems>> {
        return listWeathers
    }
}