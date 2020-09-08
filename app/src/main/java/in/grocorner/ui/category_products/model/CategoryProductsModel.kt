package `in`.grocorner.ui.category_products.model

data class CategoryProductsModel(
    val categoryName: String,
    val categoryMRP: Int,
    val categorySellingPrice: Int,
    val discountPercent: Float,
    val quantity: Int,
    val categoryImageURL: String
)