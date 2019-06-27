package com.dariopellegrini.kotlinui.kview

import android.view.View
import android.view.ViewGroup
import com.dariopellegrini.kotlinui.delegate.Delegate
import com.dariopellegrini.kotlinui.ui.ViewAdding
import com.dariopellegrini.kotlinui.ui.body.configure

typealias ViewClosure = ViewAdding.() -> View
interface KView {
    val body: ViewClosure
}

var KView.refresh: () -> Unit by Delegate({})

var KView.viewAdding: ViewAdding? by Delegate(null)

var KView.lastView: View? by Delegate(null)

fun <T>KView.observable(value: T): Delegate<T> {
    return Delegate(value) {
        refreshView()
    }
}

fun KView.refreshView() {
    viewAdding?.let { viewAdding ->
        lastView?.let {
                lastView ->
            (lastView.parent as? ViewGroup)?.let {
                viewGroup ->
                viewGroup.removeView(lastView)
                viewGroup.configure(body)
            }
        }
    }
}