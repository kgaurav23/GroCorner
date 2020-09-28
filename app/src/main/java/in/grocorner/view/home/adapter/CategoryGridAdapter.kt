package `in`.grocorner.view.home.adapter

import `in`.grocorner.R
import `in`.grocorner.model.network.pojo.Category
import `in`.grocorner.view.home.fragments.HomeFragmentDirections
import `in`.grocorner.view.utility.ImageUtility
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CategoryGridAdapter(
    private val context: Context,
    private val categories: List<Category>
) : RecyclerView.Adapter<CategoryGridAdapter.ItemCategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCategoryViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_category_grid, parent, false)
        return ItemCategoryViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: ItemCategoryViewHolder, position: Int) {
        holder.apply {
            categoryName.text = categories[position].name
            ImageUtility.showImageFromUrl(
                context,
                "https://croppola.com/croppola/example-bird2/image.jpg?algorithm=croppola&aspectRatio=1&width=500&thumbnailMaximumWidth=150",
                categoryImage
            )
        }
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
        val categoryName: TextView = itemView.findViewById(R.id.tv_category_name)
        val categoryImage: ImageView = itemView.findViewById(R.id.img_item)
    }
}