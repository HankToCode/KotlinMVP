package com.kotlin.base.rx

import com.kotlin.base.common.ResultCode
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function
/**
 * @author:     张荣东
 * @date:       2019年9月3日15:15:37
 * @desciption: 通用数据类型转换封装
 */
class BaseFunc<T> : Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        return if (t.status != ResultCode.SUCCESS) {
            Observable.error(BaseException(t.status, t.message))
        } else {
            Observable.just(t.data)
        }
    }
}