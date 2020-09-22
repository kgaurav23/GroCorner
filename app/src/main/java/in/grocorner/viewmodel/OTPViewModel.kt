package `in`.grocorner.viewmodel

import `in`.grocorner.R
import `in`.grocorner.model.database.GroCornerDatabase
import `in`.grocorner.model.network.api.NetworkProvider.getApiService
import `in`.grocorner.model.network.pojo.User
import `in`.grocorner.model.repository.OTPRepositoryImpl
import `in`.grocorner.view.login.contract.OTPContract
import `in`.grocorner.viewmodel.uistate.ErrorState
import `in`.grocorner.viewmodel.uistate.LoaderState
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class OTPViewModel(val app: Application) : AndroidViewModel(app), OTPContract.OtpVM {

    private val repository = OTPRepositoryImpl(getApiService(app))

    val loginComplete = MutableLiveData<Boolean>()
    val loaderState = MutableLiveData<LoaderState>()
    val errorState = MutableLiveData<ErrorState>()
    val otp = MutableLiveData<String>()

    private val db by lazy { GroCornerDatabase(getApplication()).userDao() }

    override fun sendOTP(phoneNumber: String) {
        loaderState.value = LoaderState(true)
        viewModelScope.launch(IO) {
            try {
                val response = repository.sendOTP(phoneNumber = phoneNumber)
                val sendOtpResponse = response.body()
                otp.postValue(
                    sendOtpResponse?.data?.substring
                        (sendOtpResponse.data.indexOf('.') + 2)
                )
            } catch (ex: Exception) {

            }
        }
    }

    override fun validateOTP(otp: String, phoneNumber: String, deviceId: String) {
        if (!isOtpFilled(otp)) {
            errorState.value = ErrorState(app.getString(R.string.otp_invalid_error_message))
            return
        }

        loaderState.value = LoaderState(true)
        viewModelScope.launch(IO) {
            try {
                val response = repository.validateOTP(otp, phoneNumber, deviceId)
                val sendOtpResponse = response.body()
                saveTokenInDB(sendOtpResponse?.data)
            } catch (ex: Exception) {

            }
        }
    }

    private suspend fun saveTokenInDB(token: String?) {
        if (token == null) {
            return
        }

        val user = User(
            userName = "Kumar Gaurav",
            encryptedToken = token,
            mobileNumber = "1234567890",
            emailId = "kumar.gaurav@gmail.com"
        )
        db.insertUser(user)
        loaderState.postValue(LoaderState(false))
        loginComplete.postValue(true)
    }

    private fun isOtpFilled(otp: String) = otp.length == 5
}