package com.jeon.mvvm_weather.datas

import com.google.gson.annotations.SerializedName

/**
 * {
 * "id":429009,
 * "weather_state_name":"Clear",
 * "weather_state_abbr":"c",
 * "wind_direction_compass":"NW",
 * "created":"2013-04-30T22:55:17.582290Z",
 * "applicable_date":"2013-04-30",
 * "min_temp":null,"max_temp":null,
 * "the_temp":27.67,"wind_speed":9.2608902,
 * "wind_direction":315.0,
 * "air_pressure":1012.0,
 * "humidity":37,
 * "visibility":18.191263023940188,
 * "predictability":68
 * }
 */
data class WheatherDay(
    val id:String,
    val weather_state_name: String,
    val weather_state_abbr: String,
    val wind_direction_compass: String,
    val created: String,
    val applicable_date: String,
    val min_temp: String,
    val the_temp: String,
    val wind_direction: String,
    val air_pressure: String,
    val humidity: String,
    val visibility: String,
    val predictability: String
)