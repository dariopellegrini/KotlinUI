package com.dariopellegrini.kotlinui.ui

import android.content.Context
import android.view.View
import com.dariopellegrini.kotlinui.kview.KView

interface ViewContainer {
    val context: Context
    var index: Int?

    fun addView(view: View) {
        if (index != null) {
            addAtIndexView(view, index!!)
//            index = null
        } else {
            appendView(view)
        }
    }

    fun appendView(view: View) {
    }

    fun addAtIndexView(view: View, index: Int) {
    }

    fun remove(view: View) {

    }
}

fun ViewContainer.embed(kView: KView) {
    kView.viewContainer = this
//    kView.lastView = kView.body(this)
    kView.view = kView.body(this)
}
