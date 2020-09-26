package `in`.grocorner.view.launch.presenter

import `in`.grocorner.view.launch.contract.SplashScreenContract
import android.os.Handler
import android.os.Looper

class SplashActivityPresenter(private val view: SplashScreenContract.View) :
    SplashScreenContract.Presenter {

    override fun navigateToNextScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            view.navigateToNextScreen()
        }, 2000)
    }
}