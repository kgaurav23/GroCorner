package `in`.grocorner.view.cart.adapter

import `in`.grocorner.R
import `in`.grocorner.model.network.pojo.Cart
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(
    val context: Context,
    private val cartList: List<Cart>
) :
    RecyclerView.Adapter<CartVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartVH {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false)
        return CartVH(view)
    }

    override fun getItemCount() = cartList.size

    override fun onBindViewHolder(holder: CartVH, position: Int) {
        val cartHolder = holder as CartVH
        cartHolder.apply {

        }
    }
}

class CartVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

}