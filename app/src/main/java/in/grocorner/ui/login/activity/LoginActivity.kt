package `in`.grocorner.ui.login.activity

import `in`.grocorner.R
import `in`.grocorner.ui.login.contract.LoginContract
import `in`.grocorner.ui.login.navigator.LoginNavigator
import `in`.grocorner.ui.login.presenter.LoginPresenter
import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter = LoginPresenter(this)
    }

    override fun showMobileErrorMessage(errorMessage: String) {
        TODO("Not yet implemented")
    }

    override fun showProgressDialog() {
        TODO("Not yet implemented")
    }

    override fun hideProgressDialog() {
        TODO("Not yet implemented")
    }

    override fun navigateToSRPActivity() {
        LoginNavigator.navigateToSRPActivity(this)
    }

    override fun getContext(): Context {
        return this
    }
}

