package github.kaierwen.android.viewpager2lazy.ui.bottom_navigation_view_fragment.a

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import github.kaierwen.android.viewpager2lazy.PrintLifecycleFragment
import github.kaierwen.android.viewpager2lazy.databinding.FragmentABinding

class AFragment :
    PrintLifecycleFragment(tagName = AFragment::class.java.simpleName) {

    private lateinit var homeViewModel: AViewModel
    private var _binding: FragmentABinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(AViewModel::class.java)

        _binding = FragmentABinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}