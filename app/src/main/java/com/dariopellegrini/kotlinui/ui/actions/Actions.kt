package com.dariopellegrini.kotlinui.ui.actions

import android.content.Context
import android.view.View
import android.widget.Toast
import com.dariopellegrini.kotlinui.ui.ViewContainer

fun Context.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, text, duration).show()
}

fun View.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this.context, text, duration).show()
}

fun ViewContainer.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this.context, text, duration).show()
}

fun View.onClick(closure: (View) -> Unit): View {
    this.setOnClickListener {
        closure(this)
    }
    return this
}