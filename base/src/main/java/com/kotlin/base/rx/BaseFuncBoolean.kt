package com.wuc.kotlin.base.rx

import com.kotlin.base.common.ResultCode
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
import io.reactivex.Observable
import io.reactivex.functions.Function

/**
 * @author:     张荣东
 * @date:       2019年9月3日15:15:56
 * @desciption: Boolean 类型转换封装
 */
class BaseFuncBoolean<T> : Function<BaseResp<T>, Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        return if (t.status != ResultCode.SUCCESS) {
            Observable.error(BaseException(t.status, t.message))
        } else {
            Observable.just(true)
        }
    }
}