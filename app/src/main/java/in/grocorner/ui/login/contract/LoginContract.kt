package `in`.grocorner.ui.login.contract

import android.content.Context

interface LoginContract {

    interface View {
        fun showMobileErrorMessage(errorMessage: String)
        fun showProgressDialog()
        fun hideProgressDialog()
        fun navigateToSRPActivity()
        fun getContext(): Context
    }

    interface Presenter {
        fun isValidInput(mobileNumber: String): Boolean
        fun sendOTP()
        fun validateOTP()
    }
}
