package github.kaierwen.android.viewpagerdemo.frag

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import timber.log.Timber

/**
 * 打印出Fragment的所有声明周期方法
 *
 * [https://developer.android.com/guide/fragments/lifecycle](https://developer.android.com/guide/fragments/lifecycle)
 * @author kevinzhang
 * @since 2021/8/25
 */
open class PrintLifecycleFragment(
    private val tagName: String? = null
) : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onAttach")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onCreate")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onCreateView")
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onViewCreated")
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onViewStateRestored")
        }
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onStart")
        }
        super.onStart()
    }

    override fun onResume() {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onResume")
        }
        super.onResume()
    }

    override fun onPause() {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onPause")
        }
        super.onPause()
    }

    override fun onStop() {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onStop")
        }
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onSaveInstanceState")
        }
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onDestroyView")
        }
        super.onDestroyView()
    }

    override fun onDestroy() {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onDestroy")
        }
        super.onDestroy()
    }

    override fun onDetach() {
        if (tagName?.isNotEmpty() == true) {
            Timber.i("$tagName onDetach")
        }
        super.onDetach()
    }
}