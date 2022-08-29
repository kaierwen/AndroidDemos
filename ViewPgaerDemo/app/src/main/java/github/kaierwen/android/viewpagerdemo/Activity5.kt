package github.kaierwen.android.viewpagerdemo

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputEditText
import github.kaierwen.android.viewpagerdemo.frag.TextFragment
import timber.log.Timber

class Activity5 : AppCompatActivity() {
    private val etChangeData: TextInputEditText by lazy { findViewById(R.id.etChangeData) }
    private val etAdd: TextInputEditText by lazy { findViewById(R.id.etAdd) }
    private val etAddIndex: TextInputEditText by lazy { findViewById(R.id.etAddIndex) }
    private val btnChange: Button by lazy { findViewById(R.id.btnChange) }
    private val tabLayout: TabLayout by lazy { findViewById(R.id.tabLayout) }
    private val viewPager: ViewPager by lazy { findViewById(R.id.viewPager) }
    private val myAdapter: MyAdapter by lazy {
        MyAdapter(
            supportFragmentManager,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)
        val frags =
            mutableListOf(
                TextFragment.newInstance("1"),
                TextFragment.newInstance("2"),
                TextFragment.newInstance("3"),
                TextFragment.newInstance("4")
            )
        val texts =
            mutableListOf(
                "1",
                "2",
                "3",
                "4"
            )
        myAdapter.frags.addAll(frags)
        myAdapter.texts.addAll(texts)
        viewPager.adapter = myAdapter
        tabLayout.setupWithViewPager(viewPager)
        viewPager.offscreenPageLimit = texts.size
        findViewById<Button>(R.id.btnAdd).setOnClickListener { addFragment() }
        findViewById<Button>(R.id.btnRemove).setOnClickListener { removeFragment() }
        btnChange.setOnClickListener { changeAll() }
    }

    private fun addFragment() {
        val addStr = etAdd.text.toString()
        val indexStr = etAddIndex.text.toString()
        // 转换数据成字符串列表
        val split = addStr.split(",")
        if (split.isNotEmpty() && indexStr.isNotEmpty()) {
            try {
                val index = indexStr.toInt()
                if (index in myAdapter.texts.indices) {
                    val newFrags = mutableListOf<Fragment>()
                    for (item in split) {
                        newFrags.add(TextFragment.newInstance(item))
                    }
                    myAdapter.frags.addAll(index, newFrags)
                    myAdapter.texts.addAll(index, split)
                    myAdapter.notifyDataSetChanged()
                } else {
                    toast("添加位置值越界，有效值为：${myAdapter.texts.indices}")
                }
            } catch (e: Exception) {
                toast("添加位置值不是数字，请输入数字")
            }
        }
    }

    private fun removeFragment() {

    }

    private fun changeAll() {
        val toString = etChangeData.text.toString()
        // 转换数据成字符串列表
        val split = toString.split(",")
        if (split.isNotEmpty()) {
            myAdapter.frags.clear()
            myAdapter.texts.clear()
            val newFrags = mutableListOf<Fragment>()
            for (item in split) {
                newFrags.add(TextFragment.newInstance(item))
            }
            myAdapter.frags.addAll(newFrags)
            myAdapter.texts.addAll(split)
            myAdapter.notifyDataSetChanged()
        }
    }

    private fun toast(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show()
    }

    inner class MyAdapter(fm: FragmentManager, behavior: Int) :
        FragmentStatePagerAdapter(fm, behavior) {

        val frags = mutableListOf<Fragment>()
        val texts = mutableListOf<String>()

        override fun getCount(): Int {
            Timber.d("getCount() , frags.size = ${frags.size}")
            return frags.size
        }

        override fun getItem(position: Int): Fragment {
            Timber.d("getItem() , position = ${position}")
            return frags[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return texts[position]
        }

        override fun getItemPosition(`object`: Any): Int {
            return POSITION_NONE // 设置成POSITION_NONE，ViewPager才会更新
        }
    }
}