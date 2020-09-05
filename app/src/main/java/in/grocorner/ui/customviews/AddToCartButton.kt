package `in`.grocorner.ui.customviews

import `in`.grocorner.R
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.add_to_cart_button_layout.view.*

class AddToCartButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var itemCount = 0
    private var maxItemCountAllowed = Integer.MAX_VALUE
    private lateinit var rootButtonView: View

    init {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        rootButtonView = inflater.inflate(R.layout.add_to_cart_button_layout, parent as ViewGroup)

        setupClickListenerForAddToCart()
        setupClickListenerForIncrementButton()
        setupClickListenerForDecrementButton()
    }

    private fun setupClickListenerForIncrementButton() {
        rootButtonView.increment_btn.setOnClickListener {
            if (canIncrementMore()) {
                incrementCount()
                setItemCountText()

                if (isMaximumCountReached()) {
                    disableCounterButton(this)
                }
            }
        }
    }

    private fun setupClickListenerForDecrementButton() {
        rootButtonView.decrement_btn.setOnClickListener {
            if (canDecrementMore()) {
                decrementCount()
                setItemCountText()

                if (isMinimumCountReached()) {
                    hideCountView()
                    showAddToCartButton()
                }

                if (isIncrementButtonDisabled()) {
                    enableCounterButton(increment_btn)
                }
            }
        }
    }

    private fun setupClickListenerForAddToCart() {
        rootButtonView.addToCartBtn.setOnClickListener {
            hideAddToCartButton()
            showCountView()
        }
    }

    private fun showCountView() {
        rootButtonView.item_count_view.visibility = VISIBLE
    }

    private fun hideCountView() {
        rootButtonView.item_count_view.visibility = GONE
    }

    private fun showAddToCartButton() {
        rootButtonView.addToCartBtn.visibility = VISIBLE
    }

    private fun hideAddToCartButton() {
        rootButtonView.addToCartBtn.visibility = GONE
    }

    fun getItemCount() = itemCount

    private fun canDecrementMore(): Boolean {
        return itemCount > 0
    }

    private fun canIncrementMore(): Boolean {
        return itemCount < maxItemCountAllowed
    }

    private fun incrementCount() {
        itemCount++
    }

    private fun decrementCount() {
        itemCount--
    }

    fun setInitialItemCount(count: Int) {
        itemCount = count
        hideAddToCartButton()
        showCountView()
    }

    private fun disableCounterButton(buttonView: View) {
        val button = buttonView as ImageButton
        button.isEnabled = false
        button.backgroundTintList =
            ContextCompat.getColorStateList(context, R.color.textColorGray)
    }

    private fun enableCounterButton(button: ImageButton) {
        button.isEnabled = true
        button.backgroundTintList =
            ContextCompat.getColorStateList(context, R.color.colorPrimaryDark)
    }

    private fun setItemCountText() {
        rootButtonView.item_count_tv.text = itemCount.toString()
    }

    private fun setMaxItemCount(maxItemAllowed: Int) {
        maxItemCountAllowed = maxItemAllowed
    }

    private fun isMinimumCountReached() = itemCount == 0

    private fun isMaximumCountReached() = itemCount == maxItemCountAllowed

    private fun isIncrementButtonDisabled() = !rootButtonView.increment_btn.isEnabled
}