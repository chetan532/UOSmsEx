package com.cv.uosmsex.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OtpResult(
    val Status: String = "",
    val Details: String = "",
) : Parcelable
