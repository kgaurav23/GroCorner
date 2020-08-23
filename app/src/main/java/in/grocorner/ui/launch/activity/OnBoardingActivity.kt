package `in`.grocorner.ui.launch.activity

import `in`.grocorner.R
import `in`.grocorner.ui.launch.fragment.OnBoardingFragment
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        initViews()
    }

    override fun onBackPressed() {
        if (onBoardingViewPager.currentItem == 0) {
            super.onBackPressed()
        } else {
            onBoardingViewPager.currentItem = onBoardingViewPager.currentItem - 1
        }
    }

    private fun initViews() {
        val pagerAdapter = OnBoardingPagerAdapter(this)
        onBoardingViewPager.adapter = pagerAdapter
    }

    private inner class OnBoardingPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment = OnBoardingFragment()
    }
}