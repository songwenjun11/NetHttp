package com.example.netmodel.interceptor

import okhttp3.Interceptor

/**
 * 拦截器管理器
 *
 * @author SongWenjun
 * @since 2022/7/3
 */
class InterceptorManager private constructor() {
    companion object {
        private var interceptorManager: InterceptorManager? = null

        @Synchronized
        @JvmStatic
        fun getInstance(): InterceptorManager {
            if (interceptorManager == null) {
                synchronized(InterceptorManager::class.java) {
                    if (interceptorManager == null) {
                        interceptorManager = InterceptorManager()
                    }
                }
            }
            return interceptorManager!!
        }
    }

    val interceptors: MutableList<Interceptor> = ArrayList()

    fun addInterceptor(interceptor: Interceptor) {
        interceptors.add(interceptor)
    }

    init {
        interceptors.add(BaseUrlInterceptor())
        interceptors.add(LoggingInterceptor())
    }
}