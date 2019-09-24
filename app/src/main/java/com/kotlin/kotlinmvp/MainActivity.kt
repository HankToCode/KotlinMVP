package com.kotlin.kotlinmvp

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.kotlin.base.ui.activity.BaseActivity
import java.util.*

class MainActivity : BaseActivity() {

    private var pressTime: Long = 0

    //Fragment栈管理
    private val mStack = Stack<Fragment>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
