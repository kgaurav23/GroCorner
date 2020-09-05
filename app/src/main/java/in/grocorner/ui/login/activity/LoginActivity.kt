package `in`.grocorner.ui.login.activity

import `in`.grocorner.R
import `in`.grocorner.ui.login.contract.LoginContract
import `in`.grocorner.ui.login.presenter.LoginPresenter
import `in`.grocorner.ui.navigator.AppNavigator
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        loginPresenter = LoginPresenter(this)

        login_button.setOnClickListener {
            if (loginPresenter.isValidInput(mobile_number_edit_text.text.toString())) {
                AppNavigator.navigateToOTPActivity(this)
            }
        }

        close_login_screen_view.setOnClickListener {
            finish()
        }
    }

    override fun showMobileErrorMessage(errorMessage: String) {
        mobile_number_input.error = errorMessage
    }

    override fun showProgressDialog() {
        TODO("Not yet implemented")
    }

    override fun hideProgressDialog() {
        TODO("Not yet implemented")
    }

    override fun navigateToSRPActivity() {
        AppNavigator.navigateToHomeActivity(this)
    }

    override fun getContext(): Context {
        return this
    }
}

