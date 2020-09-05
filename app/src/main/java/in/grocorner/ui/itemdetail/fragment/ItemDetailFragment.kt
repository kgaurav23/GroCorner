package `in`.grocorner.ui.itemdetail.fragment

import `in`.grocorner.R
import `in`.grocorner.ui.utility.ImageUtility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_item_detail.*

class ItemDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupCarouselView()
    }

    private fun setupCarouselView() {
        itemCarouselView.pageCount = 5
        itemCarouselView.setImageListener { position, imageView ->
            ImageUtility.showImageFromUrl(
                requireContext(),
                "https://image.shutterstock.com/image-photo/fried-rice-chicken-prepared-served-600w-724814776.jpg",
                imageView
            )
        }
        itemCarouselView.setImageClickListener { position ->
            Toast.makeText(context, "Clicked item: $position", Toast.LENGTH_SHORT).show()
        }
    }
}