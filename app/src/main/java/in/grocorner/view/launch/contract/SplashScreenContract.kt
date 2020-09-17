package `in`.grocorner.view.launch.contract

interface SplashScreenContract {

    interface View {
        fun gotoOnBoardActivity()
    }

    interface Presenter {
        fun navigateToNextScreen()
    }

}