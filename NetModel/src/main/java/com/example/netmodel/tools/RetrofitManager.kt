package com.example.netmodel.tools

import com.example.netmodel.interceptor.InterceptorManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * 类作用
 *
 * @author SongWenjun
 * @since 2022/6/24
 */
class RetrofitManager private constructor() {

    var retrofit: Retrofit? = null

    init {
        if (retrofit == null) {
            retrofit = getRetrofitInfo()
        }
    }

    companion object {
        private const val BASE_URL = "http://www.baidu.com"

        var retrofitManager: RetrofitManager? = null

        @JvmStatic
        @Synchronized
        fun getInstance(): RetrofitManager {
            if (retrofitManager == null) {
                synchronized(RetrofitManager::class.java) {
                    if (retrofitManager == null) {
                        retrofitManager = RetrofitManager()
                    }
                }
            }
            return retrofitManager!!
        }
    }

    private fun getOkhttpClient(): OkHttpClient {
        val interceptorManager = InterceptorManager.getInstance()
        val builder = OkHttpClient.Builder()
        interceptorManager.interceptors.forEach {
            builder.addInterceptor(it)
        }
        return builder
            .callTimeout(5000, TimeUnit.SECONDS)
            .connectTimeout(5000, TimeUnit.SECONDS)
            .writeTimeout(5000, TimeUnit.SECONDS)
            .readTimeout(5000, TimeUnit.SECONDS)
            .build()
    }

    private fun getRetrofitInfo(): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(getOkhttpClient())
            .build()
    }
}