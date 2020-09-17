package `in`.grocorner.model.network.pojo

data class CategoryProductsModel(
    val categoryName: String,
    val categoryMRP: Int,
    val categorySellingPrice: Int,
    val discountPercent: Float,
    val quantity: Int,
    val categoryImageURL: String
)