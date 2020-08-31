package `in`.grocorner.ui.navigator

import `in`.grocorner.ui.launch.activity.OnBoardingActivity
import `in`.grocorner.ui.login.activity.LoginActivity
import `in`.grocorner.ui.login.activity.OTPActivity
import `in`.grocorner.ui.srp.activity.HomeActivity
import android.content.Context
import android.content.Intent

object AppNavigator {

    fun navigateToOnBoardingActivity(context: Context) {
        context.startActivity(Intent(context, OnBoardingActivity::class.java))
    }

    fun navigateToOTPActivity(context: Context) {
        context.startActivity(Intent(context, OTPActivity::class.java))
    }

    fun navigateToSRPActivity(context: Context) {
        context.startActivity(Intent(context, HomeActivity::class.java))
    }

    fun navigateToLoginActivity(context: Context) {
        context.startActivity(Intent(context, LoginActivity::class.java))
    }
}