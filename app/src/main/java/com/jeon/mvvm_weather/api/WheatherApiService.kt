package com.jeon.mvvm_weather.api

import com.jeon.mvvm_weather.datas.WheatherDay
import com.jeon.mvvm_weather.datas.Wheather
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WheatherApiService {

    @GET("/api/location/search")
    fun getWheather(
        @Query("query") query: String
    ): Observable<List<Wheather>>

    @GET("/api/location/{woeid}/{year}/{month}/{day}")
    fun getWheatherDay(
        @Path("woeid") woeid: String,  @Path("year") year: String,  @Path("month") month: String, @Path("day") day:String
    ): Observable<List<WheatherDay>>

    companion object {
        fun getService() = RequestManager.getRetrofitService(WheatherApiService::class.java)
    }
}