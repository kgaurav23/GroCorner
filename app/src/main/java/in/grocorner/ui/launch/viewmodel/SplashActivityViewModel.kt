package `in`.grocorner.ui.launch.viewmodel

import `in`.grocorner.ui.launch.contract.SplashScreenContract
import android.os.Handler
import android.os.Looper

class SplashActivityViewModel(private val view: SplashScreenContract.View) : SplashScreenContract.ViewModel {

    override fun navigateToNextScreen() {
        //If first time login then else navigate to home screen
        Handler(Looper.getMainLooper()).postDelayed({
            view.gotoOnBoardActivity()
        }, 3000)
    }

}