package `in`.grocorner.model.network.pojo

data class OnBoardingData(
    var logoResource: Int,
    var headerText: String,
    var subHeaderText: String
) {
    constructor() : this(
        -1, "", ""
    )
}