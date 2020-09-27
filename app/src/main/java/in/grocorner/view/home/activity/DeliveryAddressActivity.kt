package `in`.grocorner.view.home.activity

import `in`.grocorner.R
import `in`.grocorner.view.home.fragments.DeliveryAddressListFragmentDirections
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_delivery_address.*

class DeliveryAddressActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_address)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_address_fragment) as NavHostFragment
        navController = navHostFragment.navController

        add_new_address_fab.setOnClickListener {
            val action =
                DeliveryAddressListFragmentDirections.actionDeliveryAddressListFragmentToAddNewDeliveryAddressFragment()
            navController.navigate(action)
            add_new_address_fab.visibility = View.GONE
            bottom_app_bar.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        add_new_address_fab.visibility = View.VISIBLE
        bottom_app_bar.visibility = View.VISIBLE
        if (!navController.popBackStack()) {
            finish()
        }
    }
}