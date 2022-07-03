package com.example.networkfrommvvm

import android.app.Application
import com.example.netmodel.interceptor.InterceptorManager
import com.example.netmodel.interceptor.LoggingInterceptor
import com.example.netmodel.tools.BaseUrlManager

/**
 * 类作用
 *
 * @author SongWenjun
 * @since 2022/6/25
 */
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        //初始化所有BaseUrl
        val urls = mutableMapOf<String, String>()
        urls["asds"] = "https://www.juhe.cn/"
        urls["asd"] = "http://v.juhe.cn/"
        BaseUrlManager.init(this, urls, "asds")
        //添加自定义拦截器  支持多个拦截器添加
        InterceptorManager.getInstance().addInterceptor(LoggingInterceptor())
    }
}