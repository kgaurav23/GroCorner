package `in`.grocorner.model.network

class UrlConstants {

    companion object {

        const val BASE_URL = "http://new-inventory-lb-964675459.ap-south-1.elb.amazonaws.com/"
        const val AUTHORIZATION = "Authorization"
        const val USER_ADDRESS_ENDPOINT = "api/v1/address"
        const val USER_ADDRESS_ID = "id"
        const val USER_ENDPOINT = "api/v1/users"
        const val SEND_OTP_ENDPOINT = "api/v1/send-otp"
        const val VERIFY_OTP_ENDPOINT = "api/v1/verify-otp"
        const val CATEGORY_ENDPOINT = "category/meta"
    }

}