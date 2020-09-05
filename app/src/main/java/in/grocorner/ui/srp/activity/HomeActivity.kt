package `in`.grocorner.ui.srp.activity

import `in`.grocorner.R
import `in`.grocorner.ui.category.fragment.CategoryFragment
import `in`.grocorner.ui.home.fragments.HomeFragment
import `in`.grocorner.ui.itemdetail.fragment.ItemDetailFragment
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = ContextCompat.getColor(this, R.color.off_white)

        attachHomeFragment()
    }

    private fun attachHomeFragment() {
        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
    }

    private fun attachItemDetailFragment() {
        val fragment = ItemDetailFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
    }

    private fun attachCategoryFragment() {
        val fragment = CategoryFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, fragment).commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_home -> {
                attachHomeFragment()
                true
            }
            R.id.menu_category -> {
                true
            }
            R.id.menu_cart -> {
                true
            }
            R.id.menu_payment -> {
                true
            }
            else -> false
        }
    }
}