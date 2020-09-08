package `in`.grocorner.ui.category_products.adapter

import `in`.grocorner.R
import `in`.grocorner.ui.category_products.fragment.CategoryProductsFragmentDirections
import `in`.grocorner.ui.category_products.model.CategoryProductsModel
import `in`.grocorner.ui.customviews.AddToCartButton
import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(
    val context: Context,
    private val categoryProductsList: List<CategoryProductsModel>
) :
    RecyclerView.Adapter<CategoryVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        val view =
            LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)
        return CategoryVH(view)
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        val categoryHolder = holder as CategoryVH
        categoryHolder.apply {
            categoryMRP.paintFlags = categoryMRP.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
        holder.itemView.setOnClickListener {
            navigateToItemDetailsScreen(it, position)
        }
    }

    private fun navigateToItemDetailsScreen(view: View, position: Int) {
        val itemId = ""
        val action =
            CategoryProductsFragmentDirections.actionCategoryProductsFragmentToProductDetailFragment(
                itemId
            )

        view.findNavController().navigate(action)
    }

    override fun getItemCount() = categoryProductsList.size
}

class CategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val categoryImage: ImageView = itemView.findViewById(R.id.category_image)
    val categorySellingPrice: TextView = itemView.findViewById(R.id.category_selling_price)
    val categoryMRP: TextView = itemView.findViewById(R.id.category_mrp)
    val addCategoryBtn: AddToCartButton = itemView.findViewById(R.id.category_add_btn)
    val categoryName: TextView = itemView.findViewById(R.id.category_name)
}