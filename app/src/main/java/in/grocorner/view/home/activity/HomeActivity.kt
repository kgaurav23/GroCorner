package `in`.grocorner.view.home.activity

import `in`.grocorner.R
import `in`.grocorner.view.navigator.AppNavigator
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.home_screen_layout.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorAccent)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        setupBottomNavigation()
        setupNavigationDrawer()
    }

    private fun setupNavigationDrawer() {
        nav_view.setNavigationItemSelectedListener(this)
    }

    private fun setupBottomNavigation() {
        bottom_navigation.setupWithNavController(navController)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.editProfile -> {
                AppNavigator.navigateToEditProfileActivity(this)
            }
            R.id.deliveryAddress -> {
                AppNavigator.navigateToDeliveryAddressActivity(this)
            }
            R.id.orderHistory -> {
                AppNavigator.navigateToOrderHistoryActivity(this)
            }
            R.id.storeLocator -> {
                AppNavigator.navigateToStoreLocatorActivity(this)
            }
            R.id.logOut -> {
            }
        }
        return true
    }
}