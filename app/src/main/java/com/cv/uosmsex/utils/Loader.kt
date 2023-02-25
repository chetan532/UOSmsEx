package com.cv.uosmsex.utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import com.airbnb.lottie.LottieAnimationView
import com.cv.uosmsex.R

class Loader : Dialog {
    private var loadingIndicatorView: LottieAnimationView? = null

    constructor(context: Context?) : super(context!!) {
    }

    constructor(context: Context?, theme: Int) : super(context!!, theme) {
        setContentView(R.layout.progress_dialog)
        loadingIndicatorView = findViewById(R.id.lottieView)
    }

    constructor(
        context: Context?,
        cancelable: Boolean,
        cancelListener: DialogInterface.OnCancelListener?
    ) : super(
        context!!,
        cancelable,
        cancelListener
    ) {
    }

    fun hideProgress() {
        if (loadingIndicatorView != null) {
            loadingIndicatorView!!.gone()
        }
    }
}