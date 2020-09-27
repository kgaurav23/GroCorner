package `in`.grocorner.view.home.activity

import `in`.grocorner.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class StoreLocatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_locator)
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorAccent)

    }
}