package `in`.grocorner.view.login.contract

interface OTPContract {

    interface View {
        fun showLoader()
        fun hideLoader()
        fun showError(msg: String)
        fun hideError()

        //TODO delete it later
        fun fillOTPFromResponse(otp: String)
    }

    interface OtpVM {
        fun sendOTP(phoneNumber: String)
        fun validateOTP(otp: String, phoneNumber: String, deviceId: String)
    }
}