package `in`.grocorner.ui.launch.contract

interface SplashScreenContract {

    interface View {
        fun gotoOnBoardActivity()
    }

    interface Presenter {
        fun navigateToNextScreen()
    }

}