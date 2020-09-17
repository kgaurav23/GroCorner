package `in`.grocorner.ui.cart.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cart(
    @ColumnInfo(name = "item_name")
    val itemName: String,
    @ColumnInfo(name = "item_quantity")
    val itemQuantity: Int,
    @ColumnInfo(name = "item_image_url")
    val itemImageUrl: String,
    @ColumnInfo(name = "item_price")
    val itemPrice: Float
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
