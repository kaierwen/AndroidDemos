package github.kaierwen.android.viewpager2lazy.ui.tablayout_viewpager_fragment

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * @author qiaofeng
 * @since 2022/5/26
 */
class SectionStatePagerAdapter(
    private val context: Context,
    fm: FragmentManager,
    frags: List<PlaceholderFragment>
) : FragmentStatePagerAdapter(fm) {

    val listFrag = frags

    override fun getCount(): Int {
        return TAB_TITLES.size
    }

    override fun getItem(position: Int): Fragment {
        return listFrag[position]
//        return PlaceholderFragment.newInstance(position + 1, getPageTitle(position).toString())
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }
}