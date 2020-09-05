package `in`.grocorner.ui.itemdetail.adapter

import `in`.grocorner.R
import `in`.grocorner.ui.itemdetail.model.ItemMayLikeModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemMayLikeAdapter(
    val context: Context,
    private val itemMayLikeList: List<ItemMayLikeModel>
) :
    RecyclerView.Adapter<ItemMayLikeVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMayLikeVH {
        val view =
            LayoutInflater.from(context).inflate(R.layout.layout_item_may_like_item, parent, false)
        return ItemMayLikeVH(view)
    }

    override fun getItemCount() = itemMayLikeList.size

    override fun onBindViewHolder(holder: ItemMayLikeVH, position: Int) {
        val itemMayLikeHolder = holder as ItemMayLikeVH
        itemMayLikeHolder.apply {

        }
    }
}

class ItemMayLikeVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

}