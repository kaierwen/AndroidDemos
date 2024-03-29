package github.kaierwen.android.viewpagerdemo.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import github.kaierwen.android.viewpagerdemo.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TextFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TextFragment(name: String) : PrintLifecycleFragment(tagName = name) {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_text, container, false)
        view.findViewById<TextView>(R.id.tvName).text = param1
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param fragName Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TextFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(fragName: String, param2: String? = null) =
            TextFragment(fragName).apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, fragName)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}