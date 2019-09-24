package com.kotlin.base.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * @author:     张荣东
 * @date:       2019年9月2日17:26:37
 * @desciption: Activity基类，业务相关
 */
open abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {


    lateinit var mActivityComponent: ActivityComponent

    @Inject
    lateinit var mPresenter: T

    lateinit var mProcessLoading: ProgressLoading

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        injectComponent()
        //初始化加载框
        mProcessLoading = ProgressLoading.create(this)
        //ARouter注册
        ARouter.getInstance().inject(this)
    }

    /**
     * Dagger注册
     */
    protected abstract fun injectComponent()

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
            .appComponent((application as BaseApplication).mAppComponent)
            .activityModule(ActivityModule(this))
            .lifecycleProviderModule(LifecycleProviderModule(this))
            .build()
    }

    override fun showLoading() {
        mProcessLoading.showLoading()
    }

    override fun hideLoading() {
        mProcessLoading.hideLoading()
    }

    override fun onError(error: String) {
        toast(error)
    }
}