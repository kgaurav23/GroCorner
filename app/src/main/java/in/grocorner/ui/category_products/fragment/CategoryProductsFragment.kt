package `in`.grocorner.ui.category_products.fragment

import `in`.grocorner.R
import `in`.grocorner.ui.category_products.adapter.CategoryAdapter
import `in`.grocorner.ui.category_products.model.CategoryProductsModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_category_products.*

class CategoryProductsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_products, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val categoryList = mutableListOf<CategoryProductsModel>()
        repeat(30) {
            categoryList.add(CategoryProductsModel("Daawat Rice", 620, 470, 0f, 0, ""))
        }
        context?.let {
            val categoryAdapter = CategoryAdapter(it, categoryList)
            category_rv.adapter = categoryAdapter
            category_rv.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}