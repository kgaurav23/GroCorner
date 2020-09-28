package `in`.grocorner.viewmodel

import `in`.grocorner.R
import `in`.grocorner.model.network.api.NetworkProvider
import `in`.grocorner.model.network.pojo.Category
import `in`.grocorner.model.repository.CategoryRepositoryImpl
import `in`.grocorner.view.home.contract.HomeContract
import `in`.grocorner.viewmodel.uistate.ErrorState
import `in`.grocorner.viewmodel.uistate.LoaderState
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class HomeViewModel(val app: Application) : AndroidViewModel(app), HomeContract.HomeVM {

    private val categoryRepo = CategoryRepositoryImpl(NetworkProvider.getApiService(app))

    val loaderState = MutableLiveData<LoaderState>()
    val errorState = MutableLiveData<ErrorState>()

    val categories = MutableLiveData<List<Category>>()

    override fun getCategories() {
        loaderState.value = LoaderState(true)
        viewModelScope.launch(IO) {
            try {
                val categoriesResponse = categoryRepo.getCategory()
                val data = categoriesResponse.body()?.data
                loaderState.postValue(LoaderState(false))
                categories.postValue(data)
            }catch (ex: Exception) {
                errorState.postValue(ErrorState(ex.localizedMessage ?: app.getString(R.string.generic_error_message)))
            }
        }
    }

}