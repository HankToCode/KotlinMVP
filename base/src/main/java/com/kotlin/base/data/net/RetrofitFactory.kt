package com.kotlin.base.data.net

import com.kotlin.base.common.BaseConstant
import com.kotlin.base.utils.AppPrefsUtils
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitFactory private constructor() {
    private object Holder {
        val INSTANCE = RetrofitFactory()
    }

    companion object {
        val instance: RetrofitFactory by lazy { Holder.INSTANCE }
    }

    private val retrofit: Retrofit
    private val interceptor: Interceptor

    init {
        interceptor = Interceptor { chain ->
            val request = chain.request()
                .newBuilder()
                .addHeader("Content_type", "application/json")
                .addHeader("charset", "UTF-8")
                .addHeader("token", AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN))
                .build()
            chain.proceed(request)
        }

        retrofit = Retrofit.Builder()
            .baseUrl(BaseConstant.SERVER_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(initClient())
            .build()
    }

    /**
     * Ohttp创建
     */
    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(initLogInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    /**
     * 日志拦截
     */
    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    /**
     * 具体服务实例化
     */
    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

}