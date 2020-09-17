package `in`.grocorner.view.login.activity

import `in`.grocorner.R
import `in`.grocorner.view.login.contract.LoginContract
import `in`.grocorner.view.navigator.AppNavigator
import `in`.grocorner.viewmodel.LoginViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        observeViewModel()

        login_button.setOnClickListener {
            loginViewModel.validateInput(mobile_number_edit_text.text.toString())
        }

        close_login_screen_view.setOnClickListener {
            finish()
        }
    }

    override fun showMobileErrorMessage(errorMessage: String) {
        mobile_number_input.error = errorMessage
    }

    override fun navigateToOtpActivity() {
        AppNavigator.navigateToOTPActivity(this)
    }

    private fun observeViewModel() {
        loginViewModel.validationState.observe(this, Observer {
            if(it.isValid) {
                navigateToOtpActivity()
            }else {
                mobile_number_input.error = it.msg
            }
        })
    }
}

