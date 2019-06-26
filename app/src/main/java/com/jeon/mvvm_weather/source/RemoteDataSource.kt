package com.jeon.mvvm_weather.source

import com.jeon.mvvm_weather.api.WheatherApiService
import com.jeon.mvvm_weather.datas.WheatherDay
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.Observable
import io.reactivex.subjects.AsyncSubject
import java.util.*
import java.util.Calendar.*


class RemoteDataSource(
    private val apiService: WheatherApiService,
    private val compositeDisposable: CompositeDisposable
) : DataSource {

    /**
     *   Single<List<Restaurant>> restaurantListSingle =
    ddApi.getUserInfo(userId).flatMap(user -> {
    return ddApi.getAvailableRestaurant(user.defaultAddress.lat, user.defaultAddress.lng);
    });
     */
    override fun loadWheatherDatas(query: String, calendar:Calendar, callback: DataSource.LoadCallback) {
        val observableRet: Observable<List<WheatherDay>> = Observable.empty()

        apiService.getWheather(query)
            .subscribeOn(Schedulers.io())

            .subscribe { wheatherList ->
                val result: MutableList<WheatherDay> = mutableListOf()
                val asyncSubject = AsyncSubject.create<List<WheatherDay>>()
                val observables: MutableList<Observable<WheatherDay>> = mutableListOf()



                wheatherList.iterator().forEach { wheather ->

                    observables.add(
                        apiService.getWheatherDay(
                            wheather.woeid.toString(),
                            calendar.get(YEAR).toString(),
                            (calendar.get(MONTH) + 1).toString(),
                            calendar.get(DATE).toString()
                        ).map { today ->
                            today[0]
                        }

                    )

                }
                Observable.merge(observables).map {
                    result.add(it)
                    result
                }.subscribe(asyncSubject)
                asyncSubject
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        callback.onResult(it)
                    }.let {
                        compositeDisposable.add(it)
                    }

            }.let {
                compositeDisposable.add(it)
            }


    }


}