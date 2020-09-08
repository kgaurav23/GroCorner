package `in`.grocorner.ui.home.adapter

import `in`.grocorner.R
import `in`.grocorner.ui.home.fragments.CategoryListFragmentDirections
import `in`.grocorner.ui.home.model.ItemCategory
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CategoryListAdapter(
    private val context: Context,
    private val categories: List<ItemCategory>
) : RecyclerView.Adapter<CategoryListAdapter.CategoryDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDetailsViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_category_list, parent, false)
        return CategoryDetailsViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryDetailsViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            navigateToCategoryItems(it, position)
        }
    }

    private fun navigateToCategoryItems(view: View, position: Int) {
        val categoryId = ""
        val action =
            CategoryListFragmentDirections.actionCategoryListFragmentToCategoryProductsFragment(categoryId)
        view.findNavController().navigate(action)
    }

    class CategoryDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}