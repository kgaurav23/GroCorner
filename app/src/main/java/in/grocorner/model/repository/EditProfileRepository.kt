package `in`.grocorner.model.repository

import `in`.grocorner.model.network.pojo.EditProfileRequest
import `in`.grocorner.model.network.pojo.EditProfileResponse
import retrofit2.Response

interface EditProfileRepository {
    suspend fun updateProfile(authToken: String, request: EditProfileRequest): Response<EditProfileResponse>
}