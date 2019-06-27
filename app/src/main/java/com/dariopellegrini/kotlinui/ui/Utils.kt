package com.dariopellegrini.kotlinui.ui

import android.view.View
import com.dariopellegrini.kotlinui.recycler.Row

fun rowFromView(view: View): Row {
    return object: Row {
        override val view: View
            get() = view
    }
}