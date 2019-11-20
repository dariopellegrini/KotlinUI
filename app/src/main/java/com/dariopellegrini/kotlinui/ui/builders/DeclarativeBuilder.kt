package com.dariopellegrini.kotlinui.ui.builders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dariopellegrini.kotlinui.recycler.RecyclerManager
import com.dariopellegrini.kotlinui.recycler.Row
import com.dariopellegrini.kotlinui.ui.ViewContainer
import com.dariopellegrini.kotlinui.ui.rowFromView

class DeclarativeBuilder(recyclerView: RecyclerView,
                         layoutManager: RecyclerView.LayoutManager): ViewContainer {
    override var index: Int? = null
    override val context = recyclerView.context
    val recyclerManager = RecyclerManager(recyclerView, layoutManager)

    override fun appendView(view: View) {
        this.recyclerManager.append(rowFromView(view), true, false)
    }

    override fun addAtIndexView(view: View, index: Int) {
        this.recyclerManager.add(rowFromView(view), index, true, false)
    }

    override fun remove(view: View) {
        index?.let {
            this.recyclerManager.remove(it, true, true)
        }
    }
}


infix fun DeclarativeBuilder.add(row: Row) {
    this.recyclerManager.append(row, true, true)
}

infix fun DeclarativeBuilder.add(rows: List<Row>) {
    this.recyclerManager.append(rows, true, true)
}


infix fun DeclarativeBuilder.addView(view: View) {
    this.appendView(view)
}