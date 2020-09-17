package `in`.grocorner.view.login.contract

interface OTPContract {

    interface View {
        fun showLoader()
        fun hideLoader()
        fun showError(msg: String)
        fun hideError()
    }

    interface OtpVM {
        fun sendOTP(phoneNumber: String)
        fun validateOTP(otp: String)
    }

}