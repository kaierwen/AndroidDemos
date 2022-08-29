package github.kaierwen.android.viewpager2lazy.ui.tablayout_viewpager2_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import github.kaierwen.android.viewpager2lazy.R
import github.kaierwen.android.viewpager2lazy.databinding.ActivityTablayoutViewpager2Binding

class TabLayoutViewPager2FragmentActivity : AppCompatActivity() {

    private val _TABTITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_2,
        R.string.tab_text_3,
        R.string.tab_text_4,
        R.string.tab_text_5,
    )

    private lateinit var binding: ActivityTablayoutViewpager2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTablayoutViewpager2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(_TABTITLES, this, this)
        val viewPager: ViewPager2 = binding.viewPager2
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs

        setViewPager()

        // viewpager使用setupWithViewPager绑定tab layout
        // viewpager2使用TabLayoutMediator绑定tab layout
        // tabs.setupWithViewPager(viewPager)

        val fab: FloatingActionButton = binding.fab

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    // 测试
    private fun setViewPager(
        autoRefresh: Boolean = false,
        smoothScroll: Boolean = false
    ) {
        // smoothScroll设置为false时，当加载了第一个Tab1之后，点击TabLayout切换到Tab5, Tab2,3,4的生命周期不会走
        // ----- 第一次加载Tab1的Log -----
        // I: Tab 1 onAttach
        // I: Tab 1 onCreate
        // I: Tab 1 onViewCreated
        // I: Tab 1 onViewStateRestored
        // I: Tab 1 onStart
        // I: Tab 1 onResume
        // ----- 点击Tab5的Log -----
        // I: Tab 5 onAttach
        // I: Tab 5 onCreate
        // I: Tab 5 onViewCreated
        // I: Tab 5 onViewStateRestored
        // I: Tab 5 onStart
        // I: Tab 1 onPause
        // I: Tab 5 onResume
        // 可见只走了Tab1和Tab5的生命周期，Tab2,3,4还未初始化
        TabLayoutMediator(
            binding.tabs,
            binding.viewPager2,
            autoRefresh,
            smoothScroll
        ) { tab, position ->
            tab.text = getString(_TABTITLES[position])
        }.attach()
    }
}