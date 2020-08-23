package `in`.grocorner.ui.launch.navigator

import `in`.grocorner.ui.launch.activity.OnBoardingActivity
import android.content.Context
import android.content.Intent

class LaunchScreenNavigator {

    companion object {
        fun navigateToOnBoardingActivity(context: Context) {
            context.startActivity(Intent(context, OnBoardingActivity::class.java))
        }
    }

}