package github.kaierwen.android.viewpager2lazy.ui.bottom_navigation_view_fragment.a

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is A Fragment"
    }
    val text: LiveData<String> = _text
}