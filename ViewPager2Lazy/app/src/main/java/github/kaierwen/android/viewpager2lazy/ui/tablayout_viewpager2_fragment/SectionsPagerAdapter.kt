package github.kaierwen.android.viewpager2lazy.ui.tablayout_viewpager2_fragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(
    var tabTitles: Array<Int>,
    private val context: Context,
    fa: FragmentActivity
) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return tabTitles.size
    }

    override fun createFragment(position: Int): Fragment {
        return PlaceholderFragment.newInstance(
            position + 1,
            context.resources.getString(tabTitles[position])
        )
    }

//    override fun getItem(position: Int): Fragment {
//        // getItem is called to instantiate the fragment for the given page.
//        // Return a PlaceholderFragment (defined as a static inner class below).
//        return PlaceholderFragment.newInstance(position + 1, getPageTitle(position).toString())
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return context.resources.getString(TAB_TITLES[position])
//    }
//
//    override fun getCount(): Int {
//        return TAB_TITLES.size
//    }
}