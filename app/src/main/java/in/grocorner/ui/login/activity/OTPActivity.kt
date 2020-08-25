package `in`.grocorner.ui.login.activity

import `in`.grocorner.R
import `in`.grocorner.ui.login.contract.OTPContract
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class OTPActivity : AppCompatActivity(), OTPContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
    }

}