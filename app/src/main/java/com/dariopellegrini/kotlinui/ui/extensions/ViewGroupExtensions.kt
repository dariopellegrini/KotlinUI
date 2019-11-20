package com.dariopellegrini.kotlinui.ui.extensions

import android.view.View
import android.view.ViewGroup
import com.dariopellegrini.kotlinui.kview.KView
import com.dariopellegrini.kotlinui.ui.builders.ViewGroupBuilder

fun ViewGroup.configure(closure: ViewGroupBuilder.() -> View) {
    this.removeAllViews()
    val builder = ViewGroupBuilder(this)
    builder.closure()
}

fun ViewGroup.configure(view: View, closure: ViewGroupBuilder.() -> View) {
    this.removeView(view)
    val builder = ViewGroupBuilder(this)
    builder.closure()
}

fun ViewGroup.configure(view: View, kview: KView) {
    val index = this.indexOfChild(view)
    this.removeView(view)
    val builder = ViewGroupBuilder(this)
    val closure = kview.body
    builder.addAtIndexView(kview.body(kview.viewContainer!!), index)
//    kview.viewContainer = builder
//    kview.view = builder.closure()
}

fun ViewGroup.configure(kview: KView) {
    this.removeAllViews()
    val builder = ViewGroupBuilder(this)
    val closure = kview.body
    kview.viewContainer = builder
    kview.view = builder.closure()
}