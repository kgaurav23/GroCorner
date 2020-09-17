package `in`.grocorner.ui.login.activity

import `in`.grocorner.R
import `in`.grocorner.ui.login.presenter.OTPViewModel
import `in`.grocorner.ui.navigator.AppNavigator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_otp.*

class OTPActivity : AppCompatActivity() {

    private lateinit var otpViewModel: OTPViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        otpViewModel = ViewModelProvider(this).get(OTPViewModel::class.java)
        observeViewModel()

        login_using_otp_button.setOnClickListener {
            otpViewModel.validateOTP()
        }
    }

    private fun observeViewModel() {
        otpViewModel.validationErrorMessage.observe(this, { errorMessage ->

        })

        otpViewModel.showLoader.observe(this, { showLoader ->
            if (showLoader) {
                // show loader
            } else {
                // hide loader
            }
        })

        otpViewModel.serverErrorMessage.observe(this, { errorMessage ->

        })

        otpViewModel.loginComplete.observe(this, { _ ->
            navigateToHomeScreen()
        })
    }

    private fun navigateToHomeScreen() {
        AppNavigator.navigateToHomeActivity(this)
    }
}