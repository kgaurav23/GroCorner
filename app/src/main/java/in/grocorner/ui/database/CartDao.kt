package `in`.grocorner.ui.database

import `in`.grocorner.ui.cart.model.Cart
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(cartItem: Cart): Long

    @Query("SELECT * FROM cart")
    suspend fun getAllItemsInCart(): List<Cart>

    @Query("DELETE FROM cart")
    suspend fun deleteAllItemsInCart()

    @Query("DELETE FROM cart WHERE id = :id")
    suspend fun deleteItem(id: Long)
}