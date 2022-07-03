package com.example.netmodel.tools

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 * 抽取base
 *
 * @author SongWenjun
 * @since 2022/6/24
 */
abstract class HttpCallBackListener<T> : Observer<T> {

    abstract fun onSuccess(t: T)

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onComplete() {
    }
}