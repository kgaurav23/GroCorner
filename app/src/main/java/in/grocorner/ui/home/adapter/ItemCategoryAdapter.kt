package `in`.grocorner.ui.home.adapter

import `in`.grocorner.R
import `in`.grocorner.ui.home.model.ItemCategory
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemCategoryAdapter(
    private val context: Context,
    private val categories: List<ItemCategory>
) : RecyclerView.Adapter<ItemCategoryAdapter.ItemCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_category, parent, false)
        return ItemCategoryViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {

    }

    class ItemCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}