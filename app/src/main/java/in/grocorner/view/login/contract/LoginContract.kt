package `in`.grocorner.view.login.contract

interface LoginContract {

    interface View {
        fun showMobileErrorMessage(errorMessage: String)
        fun navigateToOtpActivity()
    }

    interface LoginVM {
        fun validateInput(mobileNumber: String)
    }
}