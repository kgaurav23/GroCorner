package `in`.grocorner.viewmodel

import `in`.grocorner.model.database.GroCornerDatabase
import `in`.grocorner.model.network.api.NetworkProvider.getApiService
import `in`.grocorner.model.network.pojo.EditProfileRequest
import `in`.grocorner.model.network.pojo.User
import `in`.grocorner.model.repository.EditProfileRepositoryImpl
import `in`.grocorner.view.home.contract.EditProfileContract
import `in`.grocorner.viewmodel.uistate.LoaderState
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class EditProfileViewModel(val app: Application) : AndroidViewModel(app),
    EditProfileContract.EditProfileVM {

    private val repository = EditProfileRepositoryImpl(getApiService(app))
    private lateinit var user: User

    val editProfileComplete = MutableLiveData<Boolean>()
    val userData = MutableLiveData<User>()
    val userInserted = MutableLiveData<Boolean>()
    val loaderState = MutableLiveData<LoaderState>()

    private val db by lazy { GroCornerDatabase(getApplication()).userDao() }

    override fun updateProfile(email: String, name: String) {
        loaderState.value = LoaderState(true)
        viewModelScope.launch(IO) {
            try {
                val token = user.encryptedToken
                val request = EditProfileRequest(
                    newEmailAddress = email,
                    newName = name
                )
                val response = repository.updateProfile(token, request)
                val editProfileResponse = response.body()
                loaderState.postValue(LoaderState(false))
                editProfileComplete.postValue(true)
            } catch (ex: Exception) {

            }
        }
    }

    fun getUserFromDBAsync() {
        loaderState.value = LoaderState(true)
        viewModelScope.launch(IO) {
            val user = getUserFromDB()
            loaderState.postValue(LoaderState(false))
            userData.postValue(user)
        }
    }

    fun saveUserInDBAsync() {
        loaderState.value = LoaderState(true)
        viewModelScope.launch(IO) {
            val user = User(
                userName = "Gaurav",
                encryptedToken = "",
                mobileNumber = "1234567890",
                emailId = ""
            )
            db.insertUser(user)
            userInserted.postValue(true)
        }
    }

    private suspend fun getUserFromDB() = db.getUser()
}