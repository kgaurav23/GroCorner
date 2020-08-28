package `in`.grocorner.ui.launch.model

data class OnBoardingData(
    var logoResource: Int,
    var headerText: String,
    var subHeaderText: String
) {
    constructor() : this(
        -1, "", ""
    )
}