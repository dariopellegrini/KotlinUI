package com.dariopellegrini.kotlinui.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class RecyclerManagerAdapter(var rows: List<Row>): RecyclerView.Adapter<RecyclerManagerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): Holder {
        val view = rows[position].view
//        view.layoutParams = ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT
//        )
        return Holder(view, this)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val row = rows[position]
        row.configuration?.invoke(holder.itemView, position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return rows.size
    }

    class Holder(itemView: View, val adapter: RecyclerManagerAdapter): RecyclerView.ViewHolder(itemView) {

        init {
//            this.itemView.setOnClickListener(this)
//            this.itemView.setOnLongClickListener(this)
        }

//        override fun onClick(v: View) {
//            if (adapterPosition > 0 && adapterPosition < adapter.rows.size) {
//                adapter.rows[adapterPosition].onClick?.invoke(itemView, adapterPosition)
//            }
//        }
//
//        override fun onLongClick(v: View): Boolean {
//            val onLongClick = adapter.rows[adapterPosition].onLongClick
//            if (onLongClick != null) {
//                onLongClick(itemView, adapterPosition)
//                return true
//            }
//            return false
//        }
    }
}