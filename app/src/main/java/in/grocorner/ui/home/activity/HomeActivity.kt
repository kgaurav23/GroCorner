package `in`.grocorner.ui.home.activity

import `in`.grocorner.R
import `in`.grocorner.ui.cart.fragment.CartFragment
import `in`.grocorner.ui.category.fragment.CategoryItemsFragment
import `in`.grocorner.ui.home.fragments.CategoryFragment
import `in`.grocorner.ui.home.fragments.HomeFragment
import `in`.grocorner.ui.itemdetail.fragment.ItemDetailFragment
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.home_screen_layout.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorAccent)

        bottom_navigation.setOnNavigationItemSelectedListener(this)
        attachCartFragment()
    }

    private fun attachCartFragment() {
        val fragment = CartFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    private fun attachHomeFragment() {
        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    private fun attachCategoryFragment() {
        val fragment = CategoryFragment()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit()
    }

    private fun attachItemDetailFragment() {
        val fragment = ItemDetailFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
    }

    private fun attachCategoryItemFragment() {
        val fragment = CategoryItemsFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                attachHomeFragment()
                true
            }
            R.id.menu_category -> {
                attachCategoryFragment()
                true
            }
            R.id.menu_offer -> {
                true
            }
            R.id.menu_cart -> {
                true
            }
            else -> false
        }
    }
}