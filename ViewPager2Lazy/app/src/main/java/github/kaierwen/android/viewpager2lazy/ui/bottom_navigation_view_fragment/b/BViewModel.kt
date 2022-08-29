package github.kaierwen.android.viewpager2lazy.ui.bottom_navigation_view_fragment.b

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is B Fragment"
    }
    val text: LiveData<String> = _text
}