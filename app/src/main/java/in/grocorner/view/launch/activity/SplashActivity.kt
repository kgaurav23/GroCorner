package `in`.grocorner.view.launch.activity

import `in`.grocorner.R
import `in`.grocorner.view.launch.contract.SplashScreenContract
import `in`.grocorner.view.launch.presenter.SplashActivityPresenter
import `in`.grocorner.view.navigator.AppNavigator
import `in`.grocorner.view.utility.AppUtility
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SplashActivity : AppCompatActivity(), SplashScreenContract.View {

    private lateinit var presenter: SplashScreenContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        window.statusBarColor = ContextCompat.getColor(this, R.color.off_white)

        presenter = SplashActivityPresenter(this)
        presenter.navigateToNextScreen()
    }

    override fun navigateToNextScreen() {
        if (AppUtility.didWeShowOnBoardingScreen(this)) {
            AppNavigator.navigateToHomeActivity(this)
        } else {
            AppNavigator.navigateToHomeActivity(this)
        }
    }
}