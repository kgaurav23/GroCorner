package `in`.grocorner.ui.login.activity

import `in`.grocorner.R
import `in`.grocorner.ui.login.contract.OTPContract
import `in`.grocorner.ui.navigator.AppNavigator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_otp.*

class OTPActivity : AppCompatActivity(), OTPContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        login_using_otp_button.setOnClickListener {
            AppNavigator.navigateToSRPActivity(this)
        }
    }

}