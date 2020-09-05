package `in`.grocorner.ui.cart.model

data class CartModel(
    val itemName: String,
    val itemQuantity: Int,
    val itemImageUrl: String,
    val itemPrice: Float
)