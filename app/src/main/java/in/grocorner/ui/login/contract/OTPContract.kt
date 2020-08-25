package `in`.grocorner.ui.login.contract

interface OTPContract {

    interface View {

    }

    interface Presenter {
        fun validateOTP()
    }

}