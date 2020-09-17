package `in`.grocorner.viewmodel

import `in`.grocorner.R
import `in`.grocorner.model.database.GroCornerDatabase
import `in`.grocorner.model.network.api.NetworkProvider.getApiService
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

    private val db by lazy { GroCornerDatabase(getApplication()).userDao() }

    override fun sendOTP(phoneNumber: String) {
        loaderState.value = LoaderState(true)
        viewModelScope.launch(IO) {
            try {
                val response = repository.sendOTP(phoneNumber = phoneNumber)
                val sendOtpResponse = response.body()
            }catch (ex: Exception) {

            }
        }
    }

    override fun validateOTP(otp: String) {
        if(!isOtpFilled(otp)) {
            errorState.value = ErrorState(app.getString(R.string.otp_invalid_error_message))
            return
        }

        loaderState.value = LoaderState(true)
    }

    private fun isOtpFilled(otp: String) = otp.length == 5

//    private fun insertUserInDB() {
//        viewModelScope.launch {
//            val user = User(
//                userName = "Kumar Gaurav",
//                encryptedToken = "123".hashCode().toString(),
//                mobileNumber = "1234567890",
//                emailId = "kumar.gaurav@gmail.com"
//            )
//            db.insertUser(user)
//            withContext(Dispatchers.Main) {
//                showLoader.value = false
//                loginComplete.value = true
//            }
//        }
//    }
}