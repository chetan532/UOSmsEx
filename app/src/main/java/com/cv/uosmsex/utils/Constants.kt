package com.cv.uosmsex.utils

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.Window
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.cv.uosmsex.R
import com.cv.uosmsex.presentation.main.MainActivity

object Constants {

    var BASE_URL = "https://2factor.in/API/V1/4046788b-b4e6-11ed-813b-0200cd936042/SMS/"
    var EXTRA_CONTACT_DETAILS = "ContactDetails"

    fun otpSendSuccessDialog(
        mContext: Activity,
    ) {
        val dialog = Dialog(mContext)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.otp_sent_success_dialog)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val ivClose = dialog.findViewById<TextView>(R.id.positiveBtn)

        ivClose.setOnClickListener {

            dialog.dismiss()
            val intent = Intent(mContext, MainActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
            mContext.startActivity(intent)
        }

        val window = dialog.window
        window!!.setGravity(Gravity.CENTER)
        window.setLayout(
            Toolbar.LayoutParams.MATCH_PARENT,
            Toolbar.LayoutParams.WRAP_CONTENT
        )

        if (dialog != null && !dialog.isShowing) dialog.show()
    }
}