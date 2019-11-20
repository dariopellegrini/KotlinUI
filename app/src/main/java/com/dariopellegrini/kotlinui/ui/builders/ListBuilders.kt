package com.dariopellegrini.kotlinui.ui.builders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dariopellegrini.kotlinui.constants.layoutManagerHorizontal
import com.dariopellegrini.kotlinui.recycler.RecyclerManager
import com.dariopellegrini.kotlinui.ui.ViewContainer

fun RecyclerView.build(layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this.context),
                       closure: DeclarativeBuilder.() -> Unit): RecyclerManager {
    val declarativeBuilder =
        DeclarativeBuilder(this, layoutManager)
    declarativeBuilder.closure()
    return declarativeBuilder.recyclerManager
}

fun ViewContainer.recyclerView(layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context),
                                                               closure: DeclarativeBuilder.() -> Unit): RecyclerView {
    val recyclerView = RecyclerView(context)
    this.addView(recyclerView)
    recyclerView.build(layoutManager, closure)
    return recyclerView
}

fun RecyclerView.linearLayoutManager(orientation: Int = layoutManagerHorizontal, reversed: Boolean = false): RecyclerView {
    val linearLayoutManager = LinearLayoutManager(this.context, orientation, reversed)
    this.layoutManager = linearLayoutManager
    return this
}