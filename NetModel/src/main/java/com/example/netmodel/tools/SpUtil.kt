package com.example.netmodel.tools

import android.content.Context
import android.content.SharedPreferences

/**
 * SP存储工具
 *
 * @author SongWenjun
 * @since 2022/6/24
 */
object SpUtil {
    private val sp = BaseUrlManager.context.getSharedPreferences("base_url", Context.MODE_PRIVATE)

    @JvmStatic
    fun put(key: String, value: Any) {
        val edit = sp.edit()
        when (value) {
            is String -> {
                putString(key, value, edit)
            }
            is Int -> {
                putInt(key, value, edit)
            }
            is Long -> {
                putLong(key, value, edit)
            }
            is Float -> {
                putFloat(key, value, edit)
            }
            is Boolean -> {
                putBoolean(key, value, edit)
            }
            else -> {
                throw ClassCastException("不支持的数据类型")
            }
        }
    }

    @JvmStatic
    fun putString(key: String, value: String, edit: SharedPreferences.Editor) {
        edit.putString(key, value).commit()
    }

    @JvmStatic
    fun putInt(key: String, value: Int, edit: SharedPreferences.Editor) {
        edit.putInt(key, value).commit()
    }

    @JvmStatic
    fun putBoolean(key: String, value: Boolean, edit: SharedPreferences.Editor) {
        edit.putBoolean(key, value).commit()
    }

    @JvmStatic
    fun putFloat(key: String, value: Float, edit: SharedPreferences.Editor) {
        edit.putFloat(key, value).commit()
    }

    @JvmStatic
    fun putLong(key: String, value: Long, edit: SharedPreferences.Editor) {
        edit.putLong(key, value).commit()
    }

    @JvmStatic
    fun getString(key: String): String? {
        return sp.getString(key, null)
    }

    @JvmStatic
    fun getInt(key: String): Int {
        return sp.getInt(key, 0)
    }

    @JvmStatic
    fun getLong(key: String): Long {
        return sp.getLong(key, 0)
    }

    @JvmStatic
    fun getFloat(key: String): Float {
        return sp.getFloat(key, 0f)
    }

    @JvmStatic
    fun getBoolean(key: String): Boolean {
        return sp.getBoolean(key, false)
    }

    @JvmStatic
    operator fun set(key: String, value: String) {
        put(key, value)
    }
}