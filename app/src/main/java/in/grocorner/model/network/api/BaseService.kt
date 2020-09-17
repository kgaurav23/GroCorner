package `in`.grocorner.model.network.api

import `in`.grocorner.model.network.pojo.SendOtpRequest
import `in`.grocorner.model.network.pojo.SendOtpResponse
import `in`.grocorner.model.network.pojo.User
import retrofit2.Response

interface BaseService {
    suspend fun getAddress(auth: String)
    suspend fun saveAddress(auth: String)
    suspend fun updateAddress(auth: String, addressId: String)
    suspend fun deleteAddress(auth: String, addressId: String)
    suspend fun getUser(auth: String)
    suspend fun updateUser(auth: String, userDetails: User)
    suspend fun sendOTP(request: SendOtpRequest): Response<SendOtpResponse>
    suspend fun verifyOTP(auth: String)
}