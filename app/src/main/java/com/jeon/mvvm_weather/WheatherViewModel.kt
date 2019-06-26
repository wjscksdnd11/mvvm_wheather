package com.jeon.mvvm_weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeon.mvvm_weather.api.WheatherApiService
import com.jeon.mvvm_weather.datas.WheatherDay
import com.jeon.mvvm_weather.source.DataSource
import com.jeon.mvvm_weather.source.RemoteDataSource
import io.reactivex.disposables.CompositeDisposable

class WheatherViewModel : ViewModel(){
    val compositeDisposal = CompositeDisposable()
    val apiService = WheatherApiService.getService()
    val source = RemoteDataSource(apiService,compositeDisposal)

    val wheatherDayList:MutableLiveData<List<WheatherDay>>  = MutableLiveData()

    fun loadDatas(local:String){
        source.loadWheatherDatas("se",object :DataSource.LoadCallback{
            override fun onResult(result: List<WheatherDay>) {
                wheatherDayList.postValue(result)
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposal.clear()
    }
}