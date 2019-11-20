package com.dariopellegrini.kotlinui.ui.builders

import android.view.View
import android.widget.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.dariopellegrini.kotlinui.constants.matchParent
import com.dariopellegrini.kotlinui.ui.ViewContainer


fun ViewContainer.customView(closure: () -> View): View {
    val view = closure()
    this.addView(view)
    return view
}

fun ViewContainer.textView(text: String, closure: TextView.() -> Unit = {}): TextView {
    val textView = TextView(context)
    textView.text = text
    textView.closure()
    this.addView(textView)
    return textView
}

fun ViewContainer.button(action: () -> Unit, closure: Button.() -> Unit = {}): Button {
    val button = Button(context)
    button.setOnClickListener {
        action()
    }
    button.closure()
    this.addView(button)
    return button
}

fun ViewContainer.view(closure: View.() -> Unit): View {
    val view = View(context)
    view.closure()
    this.addView(view)
    return view
}

fun ViewContainer.verticalLayout(closure: ViewGroupBuilder.() -> Unit): LinearLayout {
    val verticalLayout = LinearLayout(context).apply { orientation = LinearLayout.VERTICAL }
    val builder = ViewGroupBuilder(verticalLayout)
    builder.closure()
    this.addView(verticalLayout)
    return verticalLayout
}

fun ViewContainer.horizontalLayout(closure: ViewGroupBuilder.() -> Unit): LinearLayout {
    val horizontalLayout = LinearLayout(context).apply { orientation = LinearLayout.HORIZONTAL }
    val builder = ViewGroupBuilder(horizontalLayout)
    builder.closure()
    this.addView(horizontalLayout)
    return horizontalLayout
}

fun ViewContainer.zLayout(closure: ViewGroupBuilder.() -> Unit): FrameLayout {
    val frameLayout = FrameLayout(context)
    val builder = ViewGroupBuilder(frameLayout)
    builder.closure()
    this.addView(frameLayout)
    return frameLayout
}

fun ViewContainer.scrollView(closure: ViewGroupBuilder.() -> Unit): FrameLayout {
    val scrollView =  ScrollView(context)
    val verticalLayout = LinearLayout(context).apply { orientation = LinearLayout.VERTICAL }
    scrollView.addView(verticalLayout)
    val builder = ViewGroupBuilder(verticalLayout)
    builder.closure()
    this.addView(scrollView)
    return scrollView
}

fun ViewContainer.horizontalScrollView(closure: ViewGroupBuilder.() -> Unit): FrameLayout {
    val scrollView =  HorizontalScrollView(context)
    val horizontalLayout = LinearLayout(context).apply { orientation = LinearLayout.HORIZONTAL }
    scrollView.addView(horizontalLayout)
    val builder = ViewGroupBuilder(horizontalLayout)
    builder.closure()
    this.addView(scrollView)
    return scrollView
}

fun ViewContainer.separator(weight: Float = 1f): View {
    val view = View(context)
    this.addView(view)
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

fun ViewContainer.fixedSeparator(value: Int): View {
    val view = View(context)
    this.addView(view)
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

fun ViewContainer.swipeRefreshLayout(action: (SwipeRefreshLayout) -> Unit, closure: ViewGroupBuilder.() -> Unit): SwipeRefreshLayout {
    val swipeRefreshLayout = SwipeRefreshLayout(context)
    val builder = ViewGroupBuilder(swipeRefreshLayout)
    builder.closure()
    this.addView(swipeRefreshLayout)
    swipeRefreshLayout.setOnRefreshListener {
        action(swipeRefreshLayout)
    }
    return swipeRefreshLayout
}

