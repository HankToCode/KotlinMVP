package com.kotlin.base.injection.component

import android.content.Context
import com.kotlin.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author:     张荣东
 * @date:       2018/6/22 17:41
 * @desciption: Application级别Component
 */
@Singleton
@Component(modules = [(AppModule::class)])
interface AppComponent {
    fun context(): Context
}