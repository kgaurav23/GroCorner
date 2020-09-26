package `in`.grocorner.view.utility

import android.content.Context
import androidx.preference.PreferenceManager

class AppUtility {

    companion object {

        private const val ONBOARDING_KEY = "onboarding"

        fun didWeShowOnBoardingScreen(context: Context): Boolean {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            return preferences.getBoolean(ONBOARDING_KEY, false)
        }

        fun updateOnBoardingSettings(context: Context) {
            val preferences = PreferenceManager.getDefaultSharedPreferences(context)
            preferences.edit().apply {
                putBoolean(ONBOARDING_KEY, true)
                apply()
            }
        }
    }
}