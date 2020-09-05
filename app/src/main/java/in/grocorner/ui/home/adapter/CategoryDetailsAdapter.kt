package `in`.grocorner.ui.home.adapter

import `in`.grocorner.R
import `in`.grocorner.ui.home.model.ItemCategory
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoryDetailsAdapter(
    private val context: Context,
    private val categories: List<ItemCategory>
) : RecyclerView.Adapter<CategoryDetailsAdapter.CategoryDetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryDetailsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_category_details, parent, false)
        return CategoryDetailsViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: CategoryDetailsViewHolder, position: Int) {

    }

    class CategoryDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}