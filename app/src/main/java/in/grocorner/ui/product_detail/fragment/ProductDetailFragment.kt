package `in`.grocorner.ui.product_detail.fragment

import `in`.grocorner.R
import `in`.grocorner.ui.product_detail.adapter.ProductsMayLikeAdapter
import `in`.grocorner.ui.product_detail.adapter.ReviewsAdapter
import `in`.grocorner.ui.product_detail.model.ProductsMayLikeModel
import `in`.grocorner.ui.product_detail.model.ReviewsModel
import `in`.grocorner.ui.utility.ImageUtility
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_product_detail.*

class ProductDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupCarouselView()
        setupItemMayLikeView()
        setupReviewsView()

        item_mrp_tv.paintFlags = item_mrp_tv.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    private fun setupReviewsView() {
        val reviewsList = mutableListOf<ReviewsModel>()
        repeat(10) {
            reviewsList.add(
                ReviewsModel(
                    reviewPersonName = "Gaurav",
                    reviewContent = "I had purchased this item at very low cost from grocorner.",
                    rating = 3.5f
                )
            )
        }
        context?.let {
            val reviewsAdapter = ReviewsAdapter(it, reviewsList)
            reviews_rv.adapter = reviewsAdapter
            reviews_rv.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setupItemMayLikeView() {
        val itemMayLikeList = mutableListOf<ProductsMayLikeModel>()
        repeat(10) {
            itemMayLikeList.add(
                ProductsMayLikeModel(
                    itemName = "",
                    itemImageUrl = "",
                    itemSellingPrice = 3.5f,
                    itemMRP = 5.5f
                )
            )
        }
        context?.let {
            val itemMayLikeAdapter = ProductsMayLikeAdapter(it, itemMayLikeList)
            item_may_like_rv.adapter = itemMayLikeAdapter
            item_may_like_rv.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setupCarouselView() {
        itemCarouselView.setImageListener { position, imageView ->
            ImageUtility.showImageFromUrl(
                requireContext(),
                "https://cache.net-a-porter.com/images/products/1140673/1140673_in_2000_q80.jpg",
                imageView
            )
        }
        itemCarouselView.setImageClickListener { position ->
            Toast.makeText(context, "Clicked item: $position", Toast.LENGTH_SHORT).show()
        }
        itemCarouselView.pageCount = 5
    }
}