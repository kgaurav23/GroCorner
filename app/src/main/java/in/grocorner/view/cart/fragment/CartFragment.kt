package `in`.grocorner.view.cart.fragment

import `in`.grocorner.R
import `in`.grocorner.view.cart.adapter.CartAdapter
import `in`.grocorner.model.network.pojo.Cart
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val cartList = mutableListOf<Cart>()
        repeat(10) {
            cartList.add(
                Cart(
                    "Rice", 2,
                    "https://image.shutterstock.com/image-photo/fried-rice-chicken-prepared-served-600w-724814776.jpg",
                    300f
                )
            )
        }
        context?.let {
            val cartAdapter = CartAdapter(it, cartList)
            cart_rv.adapter = cartAdapter
            cart_rv.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        checkout_button.setOnClickListener {
            val action = CartFragmentDirections.actionCartFragmentToAddressFragment()
            findNavController().navigate(action)
        }
    }
}