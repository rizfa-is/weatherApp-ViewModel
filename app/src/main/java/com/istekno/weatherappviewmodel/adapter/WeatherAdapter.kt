package com.istekno.weatherappviewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.istekno.weatherappviewmodel.R
import com.istekno.weatherappviewmodel.model.WeatherItems
import kotlinx.android.synthetic.main.weather_items.view.*

class WeatherAdapter: RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private val dataWeather = ArrayList<WeatherItems>()

    fun setData(items: ArrayList<WeatherItems>) {
        dataWeather.clear()
        dataWeather.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): WeatherViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.weather_items, viewGroup, false)
        return WeatherViewHolder(view)
    }

    override fun onBindViewHolder(weatherViewHolder: WeatherViewHolder, position: Int) {
        weatherViewHolder.bind(dataWeather[position])
    }

    override fun getItemCount(): Int = dataWeather.size

    inner class WeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(weatherItems: WeatherItems) {
            with(itemView) {
                textCity.text = weatherItems.name
                textTemp.text = weatherItems.temperature
                textDesc.text = weatherItems.description
            }
        }
    }
}