package `in`.grocorner.model.repository

import `in`.grocorner.model.network.pojo.CategoryResponse
import retrofit2.Response

interface CategoryRepository {

    suspend fun getCategory(): Response<CategoryResponse>

}