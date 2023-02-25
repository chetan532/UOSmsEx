package com.cv.uosmsex.utils

import android.view.View
import java.util.*

fun View.animateAndShow() {
    visibility = View.VISIBLE
    alpha = 0.0f

    animate().setStartDelay(400)
        .translationY(0f)
        .alpha(1f)
        .setListener(null)
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

fun getRandomNumber(): Int {
    val r = Random(System.currentTimeMillis())
    return (1 + r.nextInt(2)) * 100000 + r.nextInt(100000)
}