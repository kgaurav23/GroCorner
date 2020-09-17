package `in`.grocorner.view.login.activity

import `in`.grocorner.R
import `in`.grocorner.view.PHONE_NUMBER
import `in`.grocorner.view.login.contract.OTPContract
import `in`.grocorner.view.navigator.AppNavigator
import `in`.grocorner.viewmodel.OTPViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_otp.*

class OTPActivity : AppCompatActivity(), OTPContract.View {

    private lateinit var otpViewModel: OTPViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        val phoneNumber = intent.getStringExtra(PHONE_NUMBER) ?: ""

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        otpViewModel = ViewModelProvider(this).get(OTPViewModel::class.java)
        otpViewModel.sendOTP(phoneNumber)

        observeViewModel()

        login_using_otp_button.setOnClickListener {
            //otpViewModel.validateOTP()
        }
    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

    override fun showError(msg: String) {

    }

    override fun hideError() {

    }

    private fun observeViewModel() {
//        otpViewModel.validationErrorMessage.observe(this, Observer { errorMessage ->
//
//        })
//
//        otpViewModel.showLoader.observe(this, Observer { showLoader ->
//            if (showLoader) {
//                // show loader
//            } else {
//                // hide loader
//            }
//        })
//
//        otpViewModel.serverErrorMessage.observe(this, Observer { errorMessage ->
//
//        })
//
//        otpViewModel.loginComplete.observe(this, Observer { _ ->
//            navigateToHomeScreen()
//        })
    }

    private fun navigateToHomeScreen() {
        AppNavigator.navigateToHomeActivity(this)
    }
}