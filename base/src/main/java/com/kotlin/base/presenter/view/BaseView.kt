package com.kotlin.base.presenter.view
/**
 * @author:     张荣东
 * @date:       2019年9月2日15:16:25
 * @desciption: MVP 中视图回调 基类
 */
interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError(error: String)
}