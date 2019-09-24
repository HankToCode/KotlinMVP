package com.kotlin.base.common

import android.app.Application
import com.kotlin.base.injection.component.AppComponent
import kotlin.properties.Delegates

/**
 *@author       张荣东
 *@date         2019年9月2日11:54:25
 *@desciption   Application基类
 */
open class BaseApplication : Application() {
    lateinit var mAppComponent: AppComponent

    /**
     * 全局伴生对象
     */
    companion object {
        var context: BaseApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()

        context = this


    }

private fun initAppInjection(){

}
}