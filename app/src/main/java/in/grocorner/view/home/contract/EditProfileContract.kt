package `in`.grocorner.view.home.contract

interface EditProfileContract {
    interface View {
        fun showLoader()
        fun hideLoader()
        fun showError(msg: String)
        fun hideError()
    }

    interface EditProfileVM {
        fun updateProfile(email: String, name: String)
    }
}