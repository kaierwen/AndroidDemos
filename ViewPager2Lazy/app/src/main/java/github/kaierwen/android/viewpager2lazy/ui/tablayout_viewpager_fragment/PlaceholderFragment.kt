package github.kaierwen.android.viewpager2lazy.ui.tablayout_viewpager_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import github.kaierwen.android.viewpager2lazy.PrintLifecycleFragment
import github.kaierwen.android.viewpager2lazy.databinding.FragmentTopTabBinding
import github.kaierwen.android.viewpager2lazy.ui.tablayout_viewpager2_fragment.PageViewModel
import github.kaierwen.android.viewpager2lazy.ui.tablayout_viewpager2_fragment.PlaceholderFragment

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment(tagName: String? = null) :
    PrintLifecycleFragment(tagName = tagName) {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentTopTabBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTopTabBinding.inflate(inflater, container, false)
        val root = binding.root

        val textView: TextView = binding.sectionLabel
        pageViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int, tagName: String? = null): PlaceholderFragment {
            return PlaceholderFragment(tagName).apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}