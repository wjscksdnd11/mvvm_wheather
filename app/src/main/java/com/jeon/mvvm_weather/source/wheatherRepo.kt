package com.jeon.mvvm_weather.source

import com.jeon.mvvm_weather.datas.DtoWheather
import com.jeon.mvvm_weather.datas.WheatherDay
import java.util.*
import java.util.Calendar.DATE

class  wheatherRepo :DataSource{

    fun loadDatas(query: String,callback: DataSource.LoadCallback){
        val calendar = Calendar.getInstance()
        loadWheatherDatas(query, calendar,object :DataSource.LoadCallback{
            override fun onResult(today: List<WheatherDay>) {
                calendar.add(DATE,1)
                val wheatherList: MutableList<DtoWheather> = mutableListOf()

                loadWheatherDatas(query,calendar,object :DataSource.LoadCallback{
                    override fun onResult(tommorow: List<WheatherDay>) {
                     today.forEachIndexed { index, today ->
//                         DtoWheather()
//                         wheatherList.add()
                     }
                    }

                })
            }

        })
    }
    override fun loadWheatherDatas(query: String, calendar: Calendar, callback: DataSource.LoadCallback) {

    }
}