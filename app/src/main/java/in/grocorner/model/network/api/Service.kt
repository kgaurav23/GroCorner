package `in`.grocorner.model.network.api

import `in`.grocorner.model.network.UrlConstants.Companion.AUTHORIZATION
import `in`.grocorner.model.network.UrlConstants.Companion.SEND_OTP_ENDPOINT
import `in`.grocorner.model.network.UrlConstants.Companion.USER_ADDRESS_ENDPOINT
import `in`.grocorner.model.network.UrlConstants.Companion.USER_ADDRESS_ID
import `in`.grocorner.model.network.UrlConstants.Companion.USER_ENDPOINT
import `in`.grocorner.model.network.UrlConstants.Companion.VERIFY_OTP_ENDPOINT
import `in`.grocorner.model.network.pojo.User
import retrofit2.http.*

interface Service {

    @GET(USER_ADDRESS_ENDPOINT)
    suspend fun getAddress(@Header(AUTHORIZATION) auth: String)

    @POST(USER_ADDRESS_ENDPOINT)
    suspend fun saveAddress(@Header(AUTHORIZATION) auth: String)

    @PUT("$USER_ADDRESS_ENDPOINT/{$USER_ADDRESS_ID}")
    suspend fun updateAddress(@Header(AUTHORIZATION) auth: String, @Path(USER_ADDRESS_ID) addressId: String)

    @DELETE("$USER_ADDRESS_ENDPOINT/{$USER_ADDRESS_ID}")
    suspend fun deleteAddress(@Header(AUTHORIZATION) auth: String, @Path(USER_ADDRESS_ID) addressId: String)

    @GET(USER_ENDPOINT)
    suspend fun getUser(@Header(AUTHORIZATION) auth: String)

    @PUT(USER_ENDPOINT)
    suspend fun updateUser(@Header(AUTHORIZATION) auth: String, @Body userDetails: User)

    @POST(SEND_OTP_ENDPOINT)
    suspend fun sendOTP(@Header(AUTHORIZATION) auth: String)

    @POST(VERIFY_OTP_ENDPOINT)
    suspend fun verifyOTP(@Header(AUTHORIZATION) auth: String)

}