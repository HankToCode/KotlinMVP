package com.kotlin.base.injection.module

import android.app.Activity
import com.kotlin.base.injection.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * @author:     张荣东
 * @date:       2019年9月2日11:53:49
 * @desciption: Activity级别Module
 */
@Module
class ActivityModule(private val activity: Activity) {


    @Provides
    @ActivityScope
    fun provideActivity(): Activity {
        return this.activity
    }

}