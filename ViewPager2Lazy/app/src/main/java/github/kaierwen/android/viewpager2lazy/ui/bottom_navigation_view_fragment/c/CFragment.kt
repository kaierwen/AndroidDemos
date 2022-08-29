package github.kaierwen.android.viewpager2lazy.ui.bottom_navigation_view_fragment.c

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import github.kaierwen.android.viewpager2lazy.PrintLifecycleFragment
import github.kaierwen.android.viewpager2lazy.databinding.FragmentCBinding

class CFragment : PrintLifecycleFragment(
    tagName = CFragment::class.java.simpleName
) {

    private lateinit var notificationsViewModel: CViewModel
    private var _binding: FragmentCBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        notificationsViewModel =
            ViewModelProvider(this).get(CViewModel::class.java)

        _binding = FragmentCBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        notificationsViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}