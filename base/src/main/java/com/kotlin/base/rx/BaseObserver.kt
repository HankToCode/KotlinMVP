package com.wuc.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.rx.BaseException
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * @author:     张荣东
 * @date:       2019年9月3日15:16:07
 * @desciption: Rx订阅者默认实现
 */
open class BaseObserver<T>(private val baseView: BaseView) : Observer<T> {

    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()
        if (e is BaseException) {
            baseView.onError(e.msg)
        }
    }
}