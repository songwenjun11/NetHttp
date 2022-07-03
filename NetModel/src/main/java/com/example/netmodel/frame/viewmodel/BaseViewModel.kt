package com.example.netmodel.frame.viewmodel

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.netmodel.tools.BaseUrlManager
import com.example.netmodel.tools.HttpCallBackListener
import com.example.netmodel.tools.HttpUtil
import io.reactivex.rxjava3.core.Observable


/**
 * BaseViewModel
 *
 * @author SongWenjun
 * @since 2022/6/24
 */
open class BaseViewModel : ViewModel() {
    open val httpUtil = HttpUtil.getInstance()
    open val notNetWorkLiveData = MutableLiveData<Int>()

    fun <T> startHttp(
        observable: Observable<T>,
        httpCallBackListener: HttpCallBackListener<T>
    ) {
        if (!checkConnectNetwork()) {
            notNetWorkLiveData.postValue(0)
            return
        }
        httpUtil.startHttp(observable, httpCallBackListener)
    }

    fun <T> startHttp(
        urlKey: String,
        observable: Observable<T>,
        httpCallBackListener: HttpCallBackListener<T>
    ) {
        if (!checkConnectNetwork()) {
            notNetWorkLiveData.postValue(0)
            return
        }
        httpUtil.startHttp(urlKey, observable, httpCallBackListener)
    }

    //判断是否联网
    private fun checkConnectNetwork(): Boolean {
        val connectivityManager =
            BaseUrlManager.context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager //获取当前网络的连接服务

        val info: NetworkInfo? = connectivityManager.getActiveNetworkInfo() //获取活动的网络连接信息
        return info != null && info.isConnected
    }
}