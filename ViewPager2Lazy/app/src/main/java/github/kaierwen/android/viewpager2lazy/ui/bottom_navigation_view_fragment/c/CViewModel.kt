package github.kaierwen.android.viewpager2lazy.ui.bottom_navigation_view_fragment.c

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is C Fragment"
    }
    val text: LiveData<String> = _text
}