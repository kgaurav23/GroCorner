package `in`.grocorner.ui.launch.activity

import `in`.grocorner.R
import `in`.grocorner.ui.launch.fragment.OnBoardingFragment
import `in`.grocorner.ui.launch.model.OnBoardingData
import android.animation.Animator
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)

        initViews()

        Handler().postDelayed({
            swipe_left_animation.visibility = View.VISIBLE
            swipe_left_animation.repeatCount = 1
            swipe_left_animation.playAnimation()
        }, 800)

        swipe_left_animation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
            }

            override fun onAnimationEnd(p0: Animator?) {
                swipe_left_animation.visibility = View.GONE
            }

            override fun onAnimationCancel(p0: Animator?) {
            }

            override fun onAnimationStart(p0: Animator?) {
            }

        })
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

        TabLayoutMediator(on_boarding_tab_layout, onBoardingViewPager)
        { tab, position -> }.attach()
    }

    private inner class OnBoardingPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            val onBoardingData = OnBoardingData()
            when (position) {
                0 -> {
                    onBoardingData.logoResource = R.drawable.ic_explore
                    onBoardingData.headerText = getString(R.string.on_boarding_explore_header)
                    onBoardingData.subHeaderText =
                        getString(R.string.on_boarding_explore_sub_header)
                }
                1 -> {
                    onBoardingData.logoResource = R.drawable.ic_payment
                    onBoardingData.headerText = getString(R.string.on_boarding_payment_header)
                    onBoardingData.subHeaderText =
                        getString(R.string.on_boarding_payment_sub_header)
                }
                2 -> {
                    onBoardingData.logoResource = R.drawable.ic_delivery
                    onBoardingData.headerText = getString(R.string.on_boarding_delivery_header)
                    onBoardingData.subHeaderText =
                        getString(R.string.on_boarding_delivery_sub_header)
                }
            }
            return OnBoardingFragment.newInstance(position, onBoardingData)
        }
    }
}