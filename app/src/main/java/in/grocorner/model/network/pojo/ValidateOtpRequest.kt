package `in`.grocorner.model.network.pojo

data class ValidateOtpRequest(
    val otp: String,
    val phoneNumber: String,
    val deviceId: String
)