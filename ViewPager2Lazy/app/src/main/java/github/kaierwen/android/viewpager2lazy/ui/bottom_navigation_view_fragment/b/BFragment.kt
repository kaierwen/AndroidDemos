package github.kaierwen.android.viewpager2lazy.ui.bottom_navigation_view_fragment.b

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import github.kaierwen.android.viewpager2lazy.PrintLifecycleFragment
import github.kaierwen.android.viewpager2lazy.databinding.FragmentBBinding

class BFragment :
    PrintLifecycleFragment(tagName = BFragment::class.java.simpleName) {

    private lateinit var dashboardViewModel: BViewModel
    private var _binding: FragmentBBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(BViewModel::class.java)

        _binding = FragmentBBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}