package com.dariopellegrini.kotlinui.recycler

import androidx.recyclerview.widget.DiffUtil


public class RecyclerDiffCallback(val oldRows: List<Row>, val newRows: List<Row>): DiffUtil.Callback() {


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldRows[oldItemPosition] == newRows[newItemPosition]
    }

    override fun getOldListSize(): Int {
        return oldRows.size
    }

    override fun getNewListSize(): Int {
        return newRows.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldRows[oldItemPosition] == newRows[newItemPosition]
    }
}