package `in`.grocorner.ui.srp.activity

import `in`.grocorner.R
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.home_screen_layout.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        window.statusBarColor = ContextCompat.getColor(this, R.color.off_white)

        setupBottomNavigationMenuItemClickListener()
    }

    private fun setupBottomNavigationMenuItemClickListener() {
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> {
                    // Do something for navigation item 1
                    true
                }
                R.id.menu_category -> {
                    // Do something for navigation item 2
                    true
                }
                R.id.menu_cart -> {
                    // Do something for navigation item 2
                    true
                }
                R.id.menu_payment -> {
                    // Do something for navigation item 2
                    true
                }
                else -> false
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}