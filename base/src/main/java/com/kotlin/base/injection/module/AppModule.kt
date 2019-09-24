package com.kotlin.base.injection.module

import android.content.Context
import com.kotlin.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author:     张荣东
 * @date:       2019年9月2日11:56:30
 * @desciption: Application级别Module
 */
@Module
class AppModule(private val context: BaseApplication) {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return this.context
    }
}