package `in`.grocorner.view.home.fragments

import `in`.grocorner.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_delivery_address.*
import kotlinx.android.synthetic.main.fragment_add_new_delivery_address.*

class AddNewDeliveryAddressFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_new_delivery_address, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        add_address_button.setOnClickListener {
            // make API call to add this new address

            // save this new address into DB once we get success response

            // pop this fragment and navigate to address List screen
            navigateToAddressListScreen()
        }
    }

    private fun navigateToAddressListScreen() {
        val action =
            AddNewDeliveryAddressFragmentDirections.actionAddNewDeliveryAddressFragmentToDeliveryAddressListFragment()
        findNavController().navigate(action)
        activity?.bottom_app_bar?.visibility = View.VISIBLE
        activity?.add_new_address_fab?.visibility = View.VISIBLE
    }
}