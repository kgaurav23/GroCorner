package `in`.grocorner.model.repository

import `in`.grocorner.model.network.api.BaseService
import `in`.grocorner.model.network.pojo.EditProfileRequest
import `in`.grocorner.model.network.pojo.EditProfileResponse
import retrofit2.Response

class EditProfileRepositoryImpl(private val service: BaseService) : EditProfileRepository {

    override suspend fun updateProfile(authToken: String, request: EditProfileRequest): Response<EditProfileResponse> {
        return service.updateUser(authToken, request)
    }
}