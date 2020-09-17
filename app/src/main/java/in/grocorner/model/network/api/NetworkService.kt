package `in`.grocorner.model.network.api

import `in`.grocorner.model.network.UrlConstants.Companion.AUTHORIZATION
import `in`.grocorner.model.network.UrlConstants.Companion.SEND_OTP_ENDPOINT
import `in`.grocorner.model.network.UrlConstants.Companion.USER_ADDRESS_ENDPOINT
import `in`.grocorner.model.network.UrlConstants.Companion.USER_ADDRESS_ID
import `in`.grocorner.model.network.UrlConstants.Companion.USER_ENDPOINT
import `in`.grocorner.model.network.UrlConstants.Companion.VERIFY_OTP_ENDPOINT
import `in`.grocorner.model.network.pojo.SendOtpRequest
import `in`.grocorner.model.network.pojo.SendOtpResponse
import `in`.grocorner.model.network.pojo.User
import retrofit2.Response
import retrofit2.http.*

interface NetworkService : BaseService {

    @GET(USER_ADDRESS_ENDPOINT)
    override suspend fun getAddress(@Header(AUTHORIZATION) auth: String)

    @POST(USER_ADDRESS_ENDPOINT)
    override suspend fun saveAddress(@Header(AUTHORIZATION) auth: String)

    @PUT("$USER_ADDRESS_ENDPOINT/{$USER_ADDRESS_ID}")
    override suspend fun updateAddress(@Header(AUTHORIZATION) auth: String, @Path(USER_ADDRESS_ID) addressId: String)

    @DELETE("$USER_ADDRESS_ENDPOINT/{$USER_ADDRESS_ID}")
    override suspend fun deleteAddress(@Header(AUTHORIZATION) auth: String, @Path(USER_ADDRESS_ID) addressId: String)

    @GET(USER_ENDPOINT)
    override suspend fun getUser(@Header(AUTHORIZATION) auth: String)

    @PUT(USER_ENDPOINT)
    override suspend fun updateUser(@Header(AUTHORIZATION) auth: String, @Body userDetails: User)

    @POST(SEND_OTP_ENDPOINT)
    override suspend fun sendOTP(@Body request: SendOtpRequest): Response<SendOtpResponse>

    @POST(VERIFY_OTP_ENDPOINT)
    override suspend fun verifyOTP(@Header(AUTHORIZATION) auth: String)

}