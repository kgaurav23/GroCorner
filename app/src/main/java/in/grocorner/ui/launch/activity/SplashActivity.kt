package `in`.grocorner.ui.launch.activity

import `in`.grocorner.R
import `in`.grocorner.ui.launch.contract.SplashScreenContract
import `in`.grocorner.ui.launch.navigator.LaunchScreenNavigator
import `in`.grocorner.ui.launch.presenter.SplashActivityPresenter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity(), SplashScreenContract.View {

    private lateinit var presenter: SplashScreenContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter = SplashActivityPresenter(this)
        presenter.navigateToNextScreen()
    }

    override fun gotoOnBoardActivity() {
        LaunchScreenNavigator.navigateToOnBoardingActivity(this)
    }
}