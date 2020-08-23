package `in`.grocorner.ui.launch.contract

interface SplashScreenContract {

    interface View {
        fun gotoOnBoardActivity()
    }

    interface ViewModel {
        fun navigateToNextScreen()
    }

}