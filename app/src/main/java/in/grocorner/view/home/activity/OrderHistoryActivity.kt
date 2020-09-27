package `in`.grocorner.view.home.activity

import `in`.grocorner.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class OrderHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_history)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorAccent)
    }
}