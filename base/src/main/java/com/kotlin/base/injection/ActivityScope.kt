package com.kotlin.base.injection

import javax.inject.Scope

/**
 * @author:     张荣东
 * @date:       2019年9月2日11:51:15
 * @desciption: Activity级别 作用域
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope