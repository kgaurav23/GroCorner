package `in`.grocorner.view.login.activity

import `in`.grocorner.R
import `in`.grocorner.view.PHONE_NUMBER
import `in`.grocorner.view.login.contract.OTPContract
import `in`.grocorner.view.navigator.AppNavigator
import `in`.grocorner.viewmodel.OTPViewModel
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
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
            otpViewModel.validateOTP(
                otp = edit_otp.text.toString(),
                phoneNumber = phoneNumber,
                deviceId = ""
            )
        }
    }

    override fun showLoader() {

    }

    override fun hideLoader() {

    }

    override fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun hideError() {

    }

    override fun fillOTPFromResponse(otp: String) {
        edit_otp.setText(otp)
        login_using_otp_button.performClick()
    }

    private fun observeViewModel() {
        otpViewModel.errorState.observe(this, Observer {
            showError(it.msg)
        })

        otpViewModel.loginComplete.observe(this, Observer { _ ->
            navigateToHomeScreen()
        })

        otpViewModel.otp.observe(this, Observer {
            fillOTPFromResponse(it)
        })
    }

    private fun navigateToHomeScreen() {
        AppNavigator.navigateToHomeActivity(this)
    }
}