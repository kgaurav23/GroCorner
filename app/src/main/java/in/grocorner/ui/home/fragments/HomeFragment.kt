package `in`.grocorner.ui.home.fragments

import `in`.grocorner.R
import `in`.grocorner.ui.home.adapter.ItemCategoryAdapter
import `in`.grocorner.ui.home.model.ItemCategory
import `in`.grocorner.ui.utility.ImageUtility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupCarouselView()
        setupViews()
    }

    private fun setupViews() {
        rv_item_category.layoutManager = GridLayoutManager(requireContext(), 3)
        rv_item_category.adapter = ItemCategoryAdapter(requireContext(), getDummyItems())
    }

    private fun setupCarouselView() {
        item_carousel.apply {
            pageCount = 5
            setImageClickListener { position ->
                Toast.makeText(context, "Clicked item: $position", Toast.LENGTH_SHORT).show()
            }
            setImageListener { _, imageView ->
                ImageUtility.showImageFromUrl(
                    requireContext(),
                    "https://image.shutterstock.com/image-photo/fried-rice-chicken-prepared-served-600w-724814776.jpg",
                    imageView
                )
            }
        }
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