package `in`.grocorner.ui.login.presenter

import `in`.grocorner.ui.database.GroCornerDatabase
import `in`.grocorner.ui.login.model.User
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OTPViewModel(application: Application) : AndroidViewModel(application) {

    val loginComplete = MutableLiveData<Boolean>()
    val showLoader = MutableLiveData<Boolean>()
    val serverErrorMessage = MutableLiveData<String>()
    val validationErrorMessage = MutableLiveData<String>()
    private val db by lazy { GroCornerDatabase(getApplication()).userDao() }

    fun validateOTP() {
        // Make Network call here...
        showLoader.value = true

        // After Receiving network SUCCESS, save Received User in Database here
        insertUserInDB()
    }

    private fun insertUserInDB() {
        viewModelScope.launch {
            val user = User(
                userName = "Kumar Gaurav",
                encryptedToken = "123".hashCode().toString(),
                mobileNumber = "1234567890",
                emailId = "kumar.gaurav@gmail.com"
            )
            db.insertUser(user)
            withContext(Dispatchers.Main) {
                showLoader.value = false
                loginComplete.value = true
            }
        }
    }
}