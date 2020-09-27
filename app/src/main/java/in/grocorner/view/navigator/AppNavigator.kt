package `in`.grocorner.view.navigator

import `in`.grocorner.view.PHONE_NUMBER
import `in`.grocorner.view.home.activity.DeliveryAddressActivity
import `in`.grocorner.view.home.activity.EditProfileActivity
import `in`.grocorner.view.home.activity.HomeActivity
import `in`.grocorner.view.home.activity.OrderHistoryActivity
import `in`.grocorner.view.launch.activity.OnBoardingActivity
import `in`.grocorner.view.login.activity.LoginActivity
import `in`.grocorner.view.login.activity.OTPActivity
import android.content.Context
import android.content.Intent
import android.net.Uri

object AppNavigator {

    fun navigateToOnBoardingActivity(context: Context) {
        context.startActivity(Intent(context, OnBoardingActivity::class.java))
    }

    fun navigateToOTPActivity(context: Context, phoneNumber: String) {
        val intent = Intent(context, OTPActivity::class.java).apply {
            putExtra(PHONE_NUMBER, phoneNumber)
        }

        context.startActivity(intent)
    }

    fun navigateToHomeActivity(context: Context) {
        context.startActivity(Intent(context, HomeActivity::class.java))
    }

    fun navigateToLoginActivity(context: Context) {
        context.startActivity(Intent(context, LoginActivity::class.java))
    }

    fun navigateToEditProfileActivity(context: Context) {
        context.startActivity(Intent(context, EditProfileActivity::class.java))
    }

    fun navigateToDeliveryAddressActivity(context: Context) {
        context.startActivity(Intent(context, DeliveryAddressActivity::class.java))
    }

    fun navigateToOrderHistoryActivity(context: Context) {
        context.startActivity(Intent(context, OrderHistoryActivity::class.java))
    }

    fun navigateToStoreLocatorActivity(context: Context) {
        val gmmIntentUri: Uri = Uri.parse("geo:0,0?q=12.9374,77.6272(Grocorner Store)")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")

        context.startActivity(mapIntent)
    }
}