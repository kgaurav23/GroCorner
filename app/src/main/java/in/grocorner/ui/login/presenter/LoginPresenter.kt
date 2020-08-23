package `in`.grocorner.ui.login.presenter

import `in`.grocorner.R
import `in`.grocorner.ui.login.contract.LoginContract
import java.util.regex.Pattern

class LoginPresenter(private val loginView: LoginContract.View) : LoginContract.Presenter {

    override fun sendOTP() {
        // Call Send OTP API here
    }

    override fun validateOTP() {
        // Call validate OTP API here
    }

    override fun isValidInput(mobileNumber: String): Boolean {
        if (mobileNumber.isBlank()) {
            loginView.showMobileErrorMessage(
                loginView.getContext().getString(R.string.mobile_number_blank_error_message)
            )
            return false
        }

        if (!isValidMobileNumber(mobileNumber)) {
            loginView.showMobileErrorMessage(
                loginView.getContext().getString(R.string.mobile_number_invalid_error_message)
            )
            return false
        }

        return true
    }

    private fun isValidMobileNumber(mobileNumber: String): Boolean {
        val mobileNumberRegex = "^[0-9]{10}$"
        val pattern = Pattern.compile(mobileNumberRegex)
        return pattern.matcher(mobileNumber).matches()
    }
}