package `in`.grocorner.ui.product_detail.adapter

import `in`.grocorner.R
import `in`.grocorner.ui.product_detail.model.ProductsMayLikeModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductsMayLikeAdapter(
    val context: Context,
    private val productsMayLikeList: List<ProductsMayLikeModel>
) :
    RecyclerView.Adapter<ItemMayLikeVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMayLikeVH {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return ItemMayLikeVH(view)
    }

    override fun getItemCount() = productsMayLikeList.size

    override fun onBindViewHolder(holder: ItemMayLikeVH, position: Int) {
        val itemMayLikeHolder = holder as ItemMayLikeVH
        itemMayLikeHolder.apply {

        }
    }
}

class ItemMayLikeVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

}