package `in`.grocorner.ui.launch.activity

import `in`.grocorner.R
import `in`.grocorner.ui.launch.contract.SplashScreenContract
import `in`.grocorner.ui.launch.presenter.SplashActivityPresenter
import `in`.grocorner.ui.navigator.AppNavigator
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

    override fun gotoOnBoardActivity() {
        AppNavigator.navigateToOnBoardingActivity(this)
    }
}