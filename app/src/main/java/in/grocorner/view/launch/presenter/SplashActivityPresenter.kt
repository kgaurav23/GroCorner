package `in`.grocorner.view.launch.presenter

import `in`.grocorner.view.launch.contract.SplashScreenContract
import android.os.Handler
import android.os.Looper

class SplashActivityPresenter(private val view: SplashScreenContract.View) : SplashScreenContract.Presenter {

    override fun navigateToNextScreen() {
        //If first time login then else navigate to home screen
        Handler(Looper.getMainLooper()).postDelayed({
            view.gotoOnBoardActivity()
        }, 3000)
    }
}