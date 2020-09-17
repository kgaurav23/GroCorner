package `in`.grocorner.model.network.pojo

data class SendOtpRequest(
    val phoneNumber: String,
    val deviceId: String
)