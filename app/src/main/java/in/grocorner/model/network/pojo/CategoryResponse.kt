package `in`.grocorner.model.network.pojo

data class CategoryResponse(
    val data: List<Category>,
    val error: String
)

data class Category(
    val categoryId: String,
    val name: String,
    val imageUrl: String
)