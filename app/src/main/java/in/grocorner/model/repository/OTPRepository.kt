package `in`.grocorner.model.repository

import `in`.grocorner.model.network.pojo.SendOtpResponse
import retrofit2.Response

interface OTPRepository {

    suspend fun sendOTP(phoneNumber: String): Response<SendOtpResponse>
    suspend fun validateOTP(otp: String)

}