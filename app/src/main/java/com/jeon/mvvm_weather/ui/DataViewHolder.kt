package com.jeon.mvvm_weather.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.jeon.mvvm_weather.R
import com.jeon.mvvm_weather.datas.WheatherDay
import kotlinx.android.synthetic.main.summary_row.view.*

class DataViewHolder private constructor (view: View,val  glide : RequestManager) : RecyclerView.ViewHolder(view) {


    fun bind(wheatherDay: WheatherDay?) {
        if (wheatherDay != null) {
            itemView.summary.text = wheatherDay.weather_state_name
            itemView.temporary.text = wheatherDay.the_temp
            itemView.temporary.text = wheatherDay.humidity
            val iconUrl = "https://www.metaweather.com/static/img/weather/png/64/${wheatherDay.weather_state_abbr}.png"
            glide.load(iconUrl).into(itemView.wheather_img)
        }
    }

    companion object {
        fun create(parent: ViewGroup, glide : RequestManager): DataViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.summary_row, parent, false)
            return DataViewHolder(view,glide)
        }
    }

}
