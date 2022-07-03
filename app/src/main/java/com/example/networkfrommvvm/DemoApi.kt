package com.example.networkfrommvvm

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

/**
 * 类作用
 *
 * @author SongWenjun
 * @since 2022/6/25
 */
interface DemoApi {
    @GET("todayOnhistory/queryEvent.php?key=efb49606d083d91ca925534f978df8ea&date=1/1")
    fun get(): Observable<DataInfo>
}