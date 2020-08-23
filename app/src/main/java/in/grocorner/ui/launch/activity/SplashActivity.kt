package `in`.grocorner.ui.launch.activity

import `in`.grocorner.R
import `in`.grocorner.ui.launch.contract.SplashScreenContract
import `in`.grocorner.ui.launch.navigator.LaunchScreenNavigator
import `in`.grocorner.ui.launch.viewmodel.SplashActivityViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity(), SplashScreenContract.View {

    private lateinit var viewModel: SplashScreenContract.ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel = SplashActivityViewModel(this)
        viewModel.navigateToNextScreen()
    }

    override fun gotoOnBoardActivity() {
        LaunchScreenNavigator.navigateToOnBoardingActivity(this)
    }
}