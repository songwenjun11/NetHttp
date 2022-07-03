package com.example.netmodel.tools

import android.app.Application
import java.lang.NullPointerException

/**
 * 用于请求多个数据源的切换
 *
 * @author SongWenjun
 * @since 2022/6/24
 */
class BaseUrlManager {
    companion object {
        lateinit var BASE_URL_DEFAULT_KEY: String
        private lateinit var urls: Map<String, String>

        @JvmStatic
        lateinit var context: Application

        @JvmStatic
        fun init(context: Application, urlMap: Map<String, String>, defaultUrlKey: String) {
            this.context = context
            urls = urlMap
            BASE_URL_DEFAULT_KEY = defaultUrlKey
        }
    }

    /**
     * 根据key切换指定的url地址
     * @param key key
     */
    fun switchUrl(key: String = BASE_URL_DEFAULT_KEY) {
        val url = urls[key]
        if (url == null || url.isEmpty()) {
            throw NullPointerException("未定义的url地址key")
        }
        SpUtil["BASE_URL"] = url
    }
}