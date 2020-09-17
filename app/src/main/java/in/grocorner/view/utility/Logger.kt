package `in`.grocorner.view.utility

import `in`.grocorner.BuildConfig
import android.util.Log

object Logger {

    private val shouldLog = BuildConfig.DEBUG
    private const val TAG = "Grocorner"

    fun d(message: String, tag: String = TAG) {
        if (!shouldLog)
            return

        Log.d(tag, message)
    }

    fun e(message: String, tag: String = TAG) {
        if (!shouldLog)
            return

        Log.e(tag, message)
    }

    fun i(message: String, tag: String = TAG) {
        if (!shouldLog)
            return

        Log.i(tag, message)
    }
}