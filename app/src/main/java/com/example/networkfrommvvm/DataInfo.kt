package com.example.networkfrommvvm

/**
 * 类作用
 *
 * @author SongWenjun
 * @since 2022/7/3
 */
class DataInfo {
    lateinit var reason: String
    lateinit var result: MutableList<Result>

    class Result {
        lateinit var day: String
        lateinit var data: String
        lateinit var title: String
        lateinit var e_id: String
    }
}