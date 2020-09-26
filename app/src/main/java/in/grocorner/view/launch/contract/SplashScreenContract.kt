package `in`.grocorner.view.launch.contract

interface SplashScreenContract {

    interface View {
        fun navigateToNextScreen()
    }

    interface Presenter {
        fun navigateToNextScreen()
    }

}