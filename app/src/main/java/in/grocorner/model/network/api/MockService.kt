package `in`.grocorner.model.network.api

import `in`.grocorner.model.network.pojo.*
import retrofit2.Response

class MockService : BaseService {
    override suspend fun getAddress(auth: String) {

    }

    override suspend fun saveAddress(auth: String) {

    }

    override suspend fun updateAddress(auth: String, addressId: String) {

    }

    override suspend fun deleteAddress(auth: String, addressId: String) {

    }

    override suspend fun getUser(auth: String) {

    }

    override suspend fun updateUser(auth: String, userDetails: User) {

    }

    override suspend fun sendOTP(request: SendOtpRequest): Response<SendOtpResponse> {
        return Response.success(SendOtpResponse("", ""))
    }

    override suspend fun verifyOTP(request: ValidateOtpRequest): Response<ValidateOtpResponse> {
        TODO("Not yet implemented")
    }
}