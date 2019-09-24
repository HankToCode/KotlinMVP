package com.kotlin.base.data.protocol

/**
 * @author:     张荣东
 * @date:       2019年9月3日13:39:20
 * @desciption:  能用响应对象
 * @status:响应状态码
 * @message:响应文字消息
 * @data:具体响应业务对象
 */
data class BaseResp<T>(val status: Int, val message: String, val data: T)