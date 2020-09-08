package `in`.grocorner.ui.home.adapter

import `in`.grocorner.R
import `in`.grocorner.ui.home.fragments.HomeFragmentDirections
import `in`.grocorner.ui.home.model.ItemCategory
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CategoryGridAdapter(
    private val context: Context,
    private val categories: List<ItemCategory>
) : RecyclerView.Adapter<CategoryGridAdapter.ItemCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_category_grid, parent, false)
        return ItemCategoryViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            navigateToCategoryItems(it, position)
        }
    }

    private fun navigateToCategoryItems(view: View, position: Int) {
        val categoryId = ""
        val action =
            HomeFragmentDirections.actionHomeFragmentToCategoryProductsFragment(categoryId)
        view.findNavController().navigate(action)
    }

    class ItemCategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}