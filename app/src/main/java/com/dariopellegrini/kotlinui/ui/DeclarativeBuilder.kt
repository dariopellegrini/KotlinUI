package com.dariopellegrini.kotlinui.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dariopellegrini.kotlinui.recycler.RecyclerManager
import com.dariopellegrini.kotlinui.recycler.Row

class DeclarativeBuilder(recyclerView: RecyclerView,
                         layoutManager: RecyclerView.LayoutManager): ViewAdding {
    override val context = recyclerView.context
    val recyclerManager = RecyclerManager(recyclerView, layoutManager)

    override fun appendView(view: View) {
        this.recyclerManager.append(rowFromView(view), true, false)
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