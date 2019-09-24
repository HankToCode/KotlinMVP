package com.kotlin.base.widgets

import android.text.Editable
import android.text.TextWatcher

/**
 * @author:     张荣东
 * @date:       2019年9月3日15:11:01
 * @desciption: 默认TextWatcher，空实现
 */
open class DefaultTextWatcher : TextWatcher {

    override fun afterTextChanged(s: Editable?) {

    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
}