package com.kotlin.base.rx

/**
 * @author:     张荣东
 * @date:       2019年9月3日11:55:40
 * @desciption: 定义通用异常
 */
class BaseException(val status: Int, val msg: String) : Throwable() {
}