package `in`.grocorner.view.login.contract

interface LoginContract {

    interface View {
        fun showMobileErrorMessage(errorMessage: String)
        fun navigateToOtpActivity(phoneNumber: String)
    }

    interface LoginVM {
        fun validateInput(mobileNumber: String)
    }
}