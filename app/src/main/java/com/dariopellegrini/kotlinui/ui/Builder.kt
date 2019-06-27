package com.dariopellegrini.kotlinui.ui

import android.view.View
import android.widget.*
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.dariopellegrini.kotlinui.constants.matchParent
import com.dariopellegrini.kotlinui.ui.dimensions.params
import com.dariopellegrini.kotlinui.ui.dimensions.paramsFromContainer


fun ViewAdding.customView(closure: () -> View): View {
    val view = closure()
    this.appendView(view)
    return view
}

fun ViewAdding.textView(text: String, closure: TextView.() -> Unit = {}): TextView {
    val textView = TextView(context)
    textView.text = text
    textView.closure()
    this.appendView(textView)
    return textView
}

fun ViewAdding.button(action: () -> Unit, closure: Button.() -> Unit = {}): Button {
    val button = Button(context)
    button.setOnClickListener {
        action()
    }
    button.closure()
    this.appendView(button)
    return button
}

fun ViewAdding.view(closure: View.() -> Unit): View {
    val view = View(context)
    view.closure()
    this.appendView(view)
    return view
}

fun ViewAdding.verticalLayout(closure: ViewGroupBuilder.() -> Unit): LinearLayout {
    val verticalLayout = LinearLayout(context).apply { orientation = LinearLayout.VERTICAL }
    val builder = ViewGroupBuilder(verticalLayout)
    builder.closure()
    this.appendView(verticalLayout)
    return verticalLayout
}

fun ViewAdding.horizontalLayout(closure: ViewGroupBuilder.() -> Unit): LinearLayout {
    val horizontalLayout = LinearLayout(context).apply { orientation = LinearLayout.HORIZONTAL }
    val builder = ViewGroupBuilder(horizontalLayout)
    builder.closure()
    this.appendView(horizontalLayout)
    return horizontalLayout
}

fun ViewAdding.zLayout(closure: ViewGroupBuilder.() -> Unit): FrameLayout {
    val frameLayout = FrameLayout(context)
    val builder = ViewGroupBuilder(frameLayout)
    builder.closure()
    this.appendView(frameLayout)
    return frameLayout
}

fun ViewAdding.scrollView(closure: ViewGroupBuilder.() -> Unit): FrameLayout {
    val scrollView =  ScrollView(context)
    val verticalLayout = LinearLayout(context).apply { orientation = LinearLayout.VERTICAL }
    scrollView.addView(verticalLayout)
    val builder = ViewGroupBuilder(verticalLayout)
    builder.closure()
    this.appendView(scrollView)
    return scrollView
}

fun ViewAdding.horizontalScrollView(closure: ViewGroupBuilder.() -> Unit): FrameLayout {
    val scrollView =  HorizontalScrollView(context)
    val horizontalLayout = LinearLayout(context).apply { orientation = LinearLayout.HORIZONTAL }
    scrollView.addView(horizontalLayout)
    val builder = ViewGroupBuilder(horizontalLayout)
    builder.closure()
    this.appendView(scrollView)
    return scrollView
}

fun ViewAdding.separator(weight: Float = 1f): View {
    val view = View(context)
    this.appendView(view)
    val parent = view.parent as? LinearLayout
    if (parent != null) {
        if (parent.orientation == LinearLayout.VERTICAL) {
            view.layoutParams = LinearLayout.LayoutParams(matchParent, 0, weight)
        }
        if (parent.orientation == LinearLayout.HORIZONTAL) {
            view.layoutParams = LinearLayout.LayoutParams(0, matchParent, weight)
        }
    }
    return view
}

fun ViewAdding.fixedSeparator(value: Int): View {
    val view = View(context)
    this.appendView(view)
    val parent = view.parent as? LinearLayout
    if (parent != null) {
        if (parent.orientation == LinearLayout.VERTICAL) {
            view.layoutParams = LinearLayout.LayoutParams(matchParent, value)
        }
        if (parent.orientation == LinearLayout.HORIZONTAL) {
            view.layoutParams = LinearLayout.LayoutParams(value, matchParent)
        }
    }
    return view
}

fun ViewAdding.swipeRefreshLayout(action: (SwipeRefreshLayout) -> Unit, closure: ViewGroupBuilder.() -> Unit): SwipeRefreshLayout {
    val swipeRefreshLayout = SwipeRefreshLayout(context)
    val builder = ViewGroupBuilder(swipeRefreshLayout)
    builder.closure()
    this.appendView(swipeRefreshLayout)
    swipeRefreshLayout.setOnRefreshListener {
        action(swipeRefreshLayout)
    }
    return swipeRefreshLayout
}

