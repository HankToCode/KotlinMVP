package com.kotlin.base.injection.component

import android.app.Activity
import android.content.Context
import com.kotlin.base.injection.ActivityScope
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.trello.rxlifecycle2.LifecycleProvider
import dagger.Component

/**
 * @author:     张荣东
 * @date:       2019年9月2日11:28:32
 * @desciption: Activity级别Component
 */
@ActivityScope
@Component(
    dependencies = [(AppComponent::class)],
    modules = [(ActivityModule::class), (LifecycleProviderModule::class)]
)
interface ActivityComponent {
    fun activity(): Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}