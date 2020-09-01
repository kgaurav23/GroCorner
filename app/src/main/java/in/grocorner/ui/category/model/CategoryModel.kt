package `in`.grocorner.ui.category.model

data class CategoryModel(
    val categoryName: String,
    val categoryMRP: Int,
    val categorySellingPrice: Int,
    val discountPercent: Float,
    val quantity: Int,
    val categoryImageURL: String
)