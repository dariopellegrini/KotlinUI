package com.dariopellegrini.kotlinui.ui.builders

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.dariopellegrini.kotlinui.ui.ViewContainer

class ViewGroupBuilder(val viewGroup: ViewGroup): ViewContainer {
    override var index: Int? = null

    override val context: Context
        get() = viewGroup.context

    override fun appendView(view: View) {
        viewGroup.addView(view)
    }

    override fun addAtIndexView(view: View, index: Int) {
        viewGroup.addView(view, index)
    }

    override fun remove(view: View) {
        viewGroup.removeView(view)
    }
}