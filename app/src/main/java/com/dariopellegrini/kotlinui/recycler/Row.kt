package com.dariopellegrini.kotlinui.recycler

import android.view.View

interface Row {
    val view: View
    val configuration: ((View, Int) -> Unit)?
        get() = null
    val onClick: ((View, Int) -> Unit)?
        get() = null
    val onLongClick: ((View, Int) -> Unit)?
        get() = null
}