package `in`.grocorner.ui.home.fragments

import `in`.grocorner.R
import `in`.grocorner.ui.home.adapter.CategoryDetailsAdapter
import `in`.grocorner.ui.home.model.ItemCategory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViews()
    }

    private fun initViews() {
        rv_category.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_category.adapter = CategoryDetailsAdapter(requireContext(), getDummyItems())
    }

    private fun getDummyItems(): List<ItemCategory> {
        return listOf(
            ItemCategory("", ""),
            ItemCategory("", ""),
            ItemCategory("", ""),
            ItemCategory("", ""),
            ItemCategory("", ""),
            ItemCategory("", ""),
            ItemCategory("", ""),
            ItemCategory("", ""),
            ItemCategory("", ""),
            ItemCategory("", "")
        )
    }

}