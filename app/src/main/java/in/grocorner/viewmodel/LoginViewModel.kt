package `in`.grocorner.viewmodel

import `in`.grocorner.R
import `in`.grocorner.view.login.contract.LoginContract
import `in`.grocorner.viewmodel.uistate.StatePhoneValidation
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import java.util.regex.Pattern

class LoginViewModel(application: Application) : AndroidViewModel(application),
    LoginContract.LoginVM {

    val validationState = MutableLiveData<StatePhoneValidation>()

    override fun validateInput(mobileNumber: String) {
        val state = StatePhoneValidation("", false)
        if (mobileNumber.isBlank()) {
            state.msg = getValidationMsg(R.string.mobile_number_blank_error_message)
        } else if (!isValidMobileNumber(mobileNumber)) {
            state.msg = getValidationMsg(R.string.mobile_number_invalid_error_message)
        } else {
            state.isValid = true
        }

        validationState.value = state
    }

    private fun isValidMobileNumber(mobileNumber: String): Boolean {
        val mobileNumberRegex = "^[0-9]{10}$"
        val pattern = Pattern.compile(mobileNumberRegex)
        return pattern.matcher(mobileNumber).matches()
    }

    private fun getValidationMsg(id: Int) = (getApplication() as Context).getString(id)
}