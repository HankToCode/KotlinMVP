package com.kotlin.provider

import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author:     张荣东
 * @date:       2019年9月2日14:56:06
 * @desciption: 跨模块接口调用  接口定义
 */
interface PushProvider : IProvider {
    fun getPushId(): String
}