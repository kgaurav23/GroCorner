package `in`.grocorner.model.repository

import `in`.grocorner.model.network.pojo.SendOtpResponse
import `in`.grocorner.model.network.pojo.ValidateOtpResponse
import retrofit2.Response

interface OTPRepository {

    suspend fun sendOTP(phoneNumber: String): Response<SendOtpResponse>
    suspend fun validateOTP(
        otp: String,
        phoneNumber: String,
        deviceId: String
    ): Response<ValidateOtpResponse>
}