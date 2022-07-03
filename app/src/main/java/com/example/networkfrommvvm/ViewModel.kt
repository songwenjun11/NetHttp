package com.example.networkfrommvvm

import androidx.lifecycle.MutableLiveData
import com.example.netmodel.frame.viewmodel.BaseViewModel
import com.example.netmodel.tools.HttpCallBackListener
import com.example.netmodel.tools.HttpUtil

/**
 * 类作用
 *
 * @author SongWenjun
 * @since 2022/6/24
 */
class ViewModel : BaseViewModel() {
    val getParamsLiveData = MutableLiveData<String>()

    fun get() {
        val apiServer = HttpUtil.getInstance().getApiServer(DemoApi::class.java)
        startHttp("asd", apiServer.get(), object : HttpCallBackListener<DataInfo>() {
            override fun onSuccess(t: DataInfo) {
                getParamsLiveData.postValue(t.reason)
            }

            override fun onError(e: Throwable?) {
                getParamsLiveData.postValue("null")
            }
        })
    }
}