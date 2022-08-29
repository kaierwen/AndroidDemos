package github.kaierwen.android.viewpager2lazy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import github.kaierwen.android.viewpager2lazy.ui.bottom_navigation_view_fragment.BottomNavigationActivity
import github.kaierwen.android.viewpager2lazy.ui.compose.ComposeBottomNavigationBarActivity
import github.kaierwen.android.viewpager2lazy.ui.tablayout_viewpager2_fragment.TabLayoutViewPager2FragmentActivity
import github.kaierwen.android.viewpager2lazy.ui.tablayout_viewpager_fragment.TabLayoutViewPagerFragmentActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toBottomNavigationActivity(view: View) {
        startActivity(Intent(this, BottomNavigationActivity::class.java))
    }

    fun toTabLayoutViewPagerActivity(view: View) {
        startActivity(Intent(this, TabLayoutViewPagerFragmentActivity::class.java))
    }

    fun toTabLayoutViewPager2Activity(view: View) {
        startActivity(Intent(this, TabLayoutViewPager2FragmentActivity::class.java))
    }

    fun toComposeBottomNavigationBarActivity(view: View) {
        startActivity(Intent(this, ComposeBottomNavigationBarActivity::class.java))
    }
}