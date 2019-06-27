package com.dariopellegrini.kotlinui.ui.body

import android.view.View
import android.view.ViewGroup
import com.dariopellegrini.kotlinui.kview.KView
import com.dariopellegrini.kotlinui.kview.lastView
import com.dariopellegrini.kotlinui.kview.viewAdding
import com.dariopellegrini.kotlinui.ui.ViewGroupBuilder

fun ViewGroup.configure(closure: ViewGroupBuilder.() -> View) {
    this.removeAllViews()
    val builder = ViewGroupBuilder(this)
    builder.closure()
}

fun ViewGroup.configure(kview: KView) {
    this.removeAllViews()
    val builder = ViewGroupBuilder(this)
    val closure = kview.body
    kview.viewAdding = builder
    kview.lastView = builder.closure()
}