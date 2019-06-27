package com.dariopellegrini.kotlinui.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.dariopellegrini.kotlinui.Wrapper

class ViewGroupBuilder(val viewGroup: ViewGroup): ViewAdding {
    override val context: Context
        get() = viewGroup.context

    override fun appendView(view: View) {
        viewGroup.addView(view)
    }
}