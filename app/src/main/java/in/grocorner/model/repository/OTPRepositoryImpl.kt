package `in`.grocorner.model.repository

import `in`.grocorner.model.network.api.BaseService
import `in`.grocorner.model.network.pojo.SendOtpRequest
import `in`.grocorner.model.network.pojo.SendOtpResponse
import retrofit2.Response

class OTPRepositoryImpl(private val service: BaseService) : OTPRepository {

    override suspend fun sendOTP(phoneNumber: String): Response<SendOtpResponse> {
        val request = SendOtpRequest(
            phoneNumber = phoneNumber,
            deviceId = ""
        )
        return service.sendOTP(request)
    }

    override suspend fun validateOTP(otp: String) {

    }
}