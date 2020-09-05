package `in`.grocorner.ui.customviews

import `in`.grocorner.R
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.add_to_cart_button_layout.view.*

class AddToCartButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var itemCount = 0
    private var maxItemCountAllowed = Integer.MAX_VALUE

    init {
        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.add_to_cart_button_layout, null)

        setupClickListenerForAddToCart()
        setupClickListenerForIncrementButton()
        setupClickListenerForDecrementButton()
    }

    private fun setupClickListenerForIncrementButton() {
        increment_btn.setOnClickListener {
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
        decrement_btn.setOnClickListener {
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
        addToCartBtn.setOnClickListener {
            hideAddToCartButton()
            showCountView()
        }
    }

    private fun showCountView() {
        item_count_view.visibility = VISIBLE
    }

    private fun hideCountView() {
        item_count_view.visibility = GONE
    }

    private fun showAddToCartButton() {
        addToCartBtn.visibility = VISIBLE
    }

    private fun hideAddToCartButton() {
        addToCartBtn.visibility = GONE
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
        item_count_tv.text = itemCount.toString()
    }

    private fun setMaxItemCount(maxItemAllowed: Int) {
        maxItemCountAllowed = maxItemAllowed
    }

    private fun isMinimumCountReached() = itemCount == 0

    private fun isMaximumCountReached() = itemCount == maxItemCountAllowed

    private fun isIncrementButtonDisabled() = !increment_btn.isEnabled
}