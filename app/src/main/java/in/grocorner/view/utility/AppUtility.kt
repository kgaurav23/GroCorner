package `in`.grocorner.view.utility

import `in`.grocorner.R
import android.content.Context
import android.util.Patterns
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.google.android.material.textfield.TextInputLayout
import java.util.*
import java.util.regex.Pattern

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

        fun checkInputFieldForErrors(context: Context): Boolean {
            val rootView = (context as AppCompatActivity).findViewById<View>(android.R.id.content)
            val textInputLayouts = findViewsWithType(rootView, TextInputLayout::class.java)

            var isValid = true
            for (textInputLayout in textInputLayouts) {
                val editText = textInputLayout.editText
                val editTextString = editText?.text.toString()

                when {
                    editTextString.isEmpty() -> {
                        textInputLayout.error =
                            context.getString(R.string.empty_field_error_message)
                        isValid = false
                    }

                    editText?.tag == "name" -> {
                        if (!isValidName(editTextString)) {
                            textInputLayout.error =
                                context.getString(R.string.invalid_name_error_message)
                            isValid = false
                        } else {
                            textInputLayout.error = null
                        }
                    }

                    editText?.tag == "email" -> {
                        if (!isValidEmailAddress(editTextString)) {
                            textInputLayout.error =
                                context.getString(R.string.invalid_email_error_message)
                            isValid = false
                        } else {
                            textInputLayout.error = null
                        }
                    }

                    editText?.tag == "phone" -> {
                        if (!isValidPhoneNumber(editTextString)) {
                            textInputLayout.error =
                                context.getString(R.string.invalid_phone_error_message)
                            isValid = false
                        } else {
                            textInputLayout.error = null
                        }
                    }

                    else -> {
                        textInputLayout.error = null
                    }
                }
            }

            return isValid
        }

        private fun <T : View> findViewsWithType(root: View, type: Class<T>): List<T> {
            val views = ArrayList<T>()
            findViewsWithType(root, type, views)
            return views
        }

        private fun <T : View> findViewsWithType(
            view: View,
            type: Class<T>,
            views: MutableList<T>
        ) {
            if (type.isInstance(view)) {
                views.add(type.cast(view)!!)
            }

            if (view is ViewGroup) {
                for (i in 0 until view.childCount) {
                    findViewsWithType(
                        view.getChildAt(i),
                        type,
                        views
                    )
                }
            }
        }

        private fun isValidEmailAddress(emailAddress: String): Boolean {
            val pattern = Patterns.EMAIL_ADDRESS
            return pattern.matcher(emailAddress).matches()
        }

        private fun isValidName(name: String): Boolean {
            val nameRegex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*\$"
            val pattern = Pattern.compile(nameRegex)
            return pattern.matcher(name).matches()
        }

        private fun isValidPhoneNumber(phoneNumber: String): Boolean {
            val phoneRegex = "^[0-9]{10}$"
            val pattern = Pattern.compile(phoneRegex)
            return pattern.matcher(phoneNumber).matches()
        }
    }
}