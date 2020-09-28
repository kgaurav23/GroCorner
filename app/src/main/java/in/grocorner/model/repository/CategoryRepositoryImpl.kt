package `in`.grocorner.model.repository

import `in`.grocorner.model.network.api.BaseService
import `in`.grocorner.model.network.pojo.CategoryResponse
import retrofit2.Response

class CategoryRepositoryImpl(private val service: BaseService) : CategoryRepository {

    override suspend fun getCategory(): Response<CategoryResponse> {
        return service.getCategory()
    }

}