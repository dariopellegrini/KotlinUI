package com.dariopellegrini.kotlinui.kview

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dariopellegrini.kotlinui.delegate.Delegate
import com.dariopellegrini.kotlinui.ui.ViewContainer
import com.dariopellegrini.kotlinui.ui.builders.ViewGroupBuilder
import com.dariopellegrini.kotlinui.ui.extensions.configure

typealias ViewClosure = ViewContainer.() -> View
abstract class KView {
    abstract val body: ViewClosure
    var view: View? = null
    var viewContainer: ViewContainer? = null
}

//var KView.viewContainer: ViewContainer? by Delegate(null)

fun <T>KView.observable(value: T): Delegate<T> {
    return Delegate(value) {
        refreshView()
    }
}

fun KView.refreshView() {
    if (view != null && viewContainer != null) {
        val parent = view?.parent
        val index = when (parent) {
            is ViewGroup -> parent.indexOfChild(view)
            is RecyclerView -> parent.indexOfChild(view)
            else -> null
        }
        viewContainer?.index = index
        viewContainer?.remove(view!!)
        view = body(viewContainer!!)
    }
}