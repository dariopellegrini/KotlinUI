package com.dariopellegrini.kotlinui.ui

import android.content.Context
import android.view.View
import com.dariopellegrini.kotlinui.kview.KView
import com.dariopellegrini.kotlinui.kview.lastView
import com.dariopellegrini.kotlinui.kview.viewAdding

interface ViewAdding {
//    val views: MutableMap<Int, View>
    val context: Context
    fun appendView(view: View) {
//        views[view.hashCode()] = view
    }
}

fun ViewAdding.embed(kView: KView) {
    kView.viewAdding = this
    kView.lastView = kView.body(this)
}
