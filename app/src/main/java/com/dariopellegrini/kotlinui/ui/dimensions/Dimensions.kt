package com.dariopellegrini.kotlinui.ui.dimensions

import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import android.util.TypedValue
import com.dariopellegrini.kotlinui.constants.matchParent
import com.dariopellegrini.kotlinui.constants.wrapContent

fun <T: View> T.margin(left: Int? = null, top: Int? = null, right: Int? = null, bottom: Int? = null): T {
    val params = this.layoutParams
    when(params) {
        is LinearLayout.LayoutParams -> params.setMargins(
                left ?: params.leftMargin,
                top ?: params.topMargin,
                right ?: params.rightMargin,
                bottom ?: params.bottomMargin)
        is FrameLayout.LayoutParams -> params.setMargins(
                left ?: params.leftMargin,
                top ?: params.topMargin,
                right ?: params.rightMargin,
                bottom ?: params.bottomMargin)
        is CoordinatorLayout.LayoutParams -> params.setMargins(
                left ?: params.leftMargin,
                top ?: params.topMargin,
                right ?: params.rightMargin,
                bottom ?: params.bottomMargin)
        is RelativeLayout.LayoutParams -> params.setMargins(
                left ?: params.leftMargin,
                top ?: params.topMargin,
                right ?: params.rightMargin,
                bottom ?: params.bottomMargin)
    }
    if (params != null) {
        this.layoutParams = params
    }
    return this
}

fun <T: View> T.paramsFromContainer(): ViewGroup.LayoutParams {
    val container = parent
    var params = this.layoutParams
    when(container) {
        is LinearLayout -> params = LinearLayout.LayoutParams(params.width, params.height)
        is FrameLayout.LayoutParams -> params = FrameLayout.LayoutParams(params.width, params.height)
        is CoordinatorLayout.LayoutParams -> params = CoordinatorLayout.LayoutParams(params.width, params.height)
        is RelativeLayout.LayoutParams -> params = RelativeLayout.LayoutParams(params.width, params.height)
        else -> {
        }
    }
    return params
}

enum class Dimensions(val value: Int) {
    MatchParent(ViewGroup.LayoutParams.MATCH_PARENT),
    WrapContent(ViewGroup.LayoutParams.WRAP_CONTENT)
}

fun <T: View>T.width(value: Int): T {
    val params = this.layoutParams
    if (params != null) {
        params.width = value
        this.layoutParams = params
    } else {
        layoutParams = ViewGroup.LayoutParams(
                value,
                ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }
    return this
}

fun <T: View>T.height(value: Int): T {
    val params = this.layoutParams
    if (params != null) {
        params.height = value
        this.layoutParams = params
    } else {
        layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                value
        )
    }
    return this
}

fun <T: View>T.params(width: Int, height: Int): T {
    val w = if (width == matchParent || width == wrapContent) width else dp(width.toFloat())
    val h = if (height == matchParent || height == wrapContent) height else dp(height.toFloat())
    val params = this.layoutParams
    if (params != null) {
        params.width = w
        params.height = h
        this.layoutParams = params
    } else {
        layoutParams = ViewGroup.LayoutParams(
                w,
                h
        )
    }
    return this
}

fun <T: View>T.dp(value: Float): Int {
    return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            value,
            resources.displayMetrics
    ).toInt()
}

fun <T: View>T.sp(value: Float): Float {
    return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_SP,
            value,
            resources.displayMetrics)
}

fun <T: View> T.layoutGravity(gravity: Int): T {
    val params = this.layoutParams
    when(params) {
        is LinearLayout.LayoutParams -> params.gravity = gravity
        is FrameLayout.LayoutParams -> params.gravity = gravity
        is CoordinatorLayout.LayoutParams -> params.gravity = gravity
    }
    return this
}