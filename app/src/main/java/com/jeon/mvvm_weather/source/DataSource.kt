package com.jeon.mvvm_weather.source

import com.jeon.mvvm_weather.datas.WheatherDay
import java.util.*

interface DataSource{
    fun loadWheatherDatas(query:String, calendar: Calendar ,callback: DataSource.LoadCallback)
    interface LoadCallback{
        fun onResult(result: List<WheatherDay>)
    }
}