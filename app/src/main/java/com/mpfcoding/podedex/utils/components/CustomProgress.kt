package com.mpfcoding.podedex.utils.components

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.view.Window
import android.widget.TextView
import com.mpfcoding.podedex.R

class CustomProgress private constructor(context: Context) : Dialog(context) {
    private var mProgressbar: CustomProgress? = null
    private var mOnDissmissListener: DialogInterface.OnDismissListener? = null

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_progressbar)
        mProgressTextView = findViewById(R.id.progress_text)
        this.window!!.setBackgroundDrawableResource(android.R.color.transparent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (mOnDissmissListener != null) {
            mOnDissmissListener!!.onDismiss(this)
        }
    }

    private fun setListener(listener: DialogInterface.OnDismissListener) {
        mOnDissmissListener = listener
    }

    fun showProgress(cancelable: Boolean) {
        if (mProgressbar != null && mProgressbar!!.isShowing) {
            mProgressbar!!.cancel()
        }
        mProgressbar!!.setCancelable(cancelable)
        mProgressbar!!.show()
    }

    companion object {
        private var mCustomProgressbar: CustomProgress? = null
        private var mProgressTextView: TextView? = null

        @JvmOverloads
        fun showProgressBar(context: Context, cancelable: Boolean, message: String? = null) {
            if (mCustomProgressbar != null && mCustomProgressbar!!.isShowing) {
                mCustomProgressbar!!.cancel()
            }
            mCustomProgressbar = CustomProgress(context)
            mProgressTextView!!.text = message
            mCustomProgressbar!!.setCancelable(cancelable)
            mCustomProgressbar!!.show()
        }

        fun showProgressBar(context: Context, listener: DialogInterface.OnDismissListener) {
            if (mCustomProgressbar != null && mCustomProgressbar!!.isShowing) {
                mCustomProgressbar!!.cancel()
            }
            mCustomProgressbar = CustomProgress(context)
            mCustomProgressbar!!.setListener(listener)
            mCustomProgressbar!!.setCancelable(java.lang.Boolean.TRUE)
            mCustomProgressbar!!.show()
        }

        fun hideProgressBar() {
            if (mCustomProgressbar != null) {
                mCustomProgressbar!!.dismiss()
            }
        }

        fun showListViewBottomProgressBar(view: View) {
            if (mCustomProgressbar != null) {
                mCustomProgressbar!!.dismiss()
            }
            view.visibility = View.VISIBLE
        }

        fun hideListViewBottomProgressBar(view: View) {
            if (mCustomProgressbar != null) {
                mCustomProgressbar!!.dismiss()
            }
            view.visibility = View.GONE
        }
    }
}