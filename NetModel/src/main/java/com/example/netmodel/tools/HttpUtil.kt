package com.example.netmodel.tools

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * 网络请求工具
 *
 * @author SongWenjun
 * @since 2022/6/24
 */
class HttpUtil private constructor() {
    //    private val retrofit = RetrofitManager().getRetrofit()
    private val urlManager = BaseUrlManager()

    companion object {
        @Synchronized
        fun getInstance(): HttpUtil {
            if (httpUtil == null) {
                synchronized(HttpUtil::class.java) {
                    if (httpUtil == null) {
                        httpUtil = HttpUtil();
                    }
                }
            }
            return httpUtil!!
        }

        private var httpUtil: HttpUtil? = null
    }

    /**
     * 获取api
     */
    fun <API> getApiServer(api: Class<API>): API {
        return RetrofitManager.getInstance().retrofit!!.create(api)
    }

    fun <T> startHttp(
        baseUrlKey: String,
        observable: Observable<T>,
        httpCallBackListener: HttpCallBackListener<T>
    ) {
        urlManager.switchUrl(baseUrlKey)
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(httpCallBackListener)
    }

    fun <T> startHttp(
        observable: Observable<T>,
        httpCallBackListener: HttpCallBackListener<T>
    ) {
        startHttp(BaseUrlManager.BASE_URL_DEFAULT_KEY, observable, httpCallBackListener)
    }
}