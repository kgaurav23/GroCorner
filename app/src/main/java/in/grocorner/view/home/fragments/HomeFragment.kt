package `in`.grocorner.view.home.fragments

import `in`.grocorner.R
import `in`.grocorner.model.network.pojo.Category
import `in`.grocorner.view.home.adapter.CategoryGridAdapter
import `in`.grocorner.view.utility.ImageUtility
import `in`.grocorner.viewmodel.HomeViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    private val categories = mutableListOf<Category>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        homeViewModel.getCategories()

        setupCarouselView()
        setupViews()
        initializeObserver()

        img_menu.setOnClickListener {
            activity?.drawer_layout?.openDrawer(GravityCompat.START)
        }
    }

    private fun setupViews() {
        rv_item_category.layoutManager = GridLayoutManager(requireContext(), 2)
        rv_item_category.adapter = CategoryGridAdapter(requireContext(), categories = categories)
    }

    private fun setupCarouselView() {
        item_carousel.apply {
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
            pageCount = 5
        }
    }

    private fun initializeObserver() {
        homeViewModel.categories.observe(requireActivity(), Observer {
            categories.clear()
            categories.addAll(it)
            rv_item_category.adapter?.notifyDataSetChanged()
        })
    }
}