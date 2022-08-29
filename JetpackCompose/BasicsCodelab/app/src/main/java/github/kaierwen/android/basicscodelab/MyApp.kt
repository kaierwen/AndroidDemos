package github.kaierwen.android.basicscodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import github.kaierwen.android.basicscodelab.ui.theme.BasicsCodelabTheme

/**
 * 可全局共用
 */
@Composable
fun MyApp() {
    BasicsCodelabTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Greeting("Android")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(12.dp))
}

/**
 * 带有下拉刷新的组件
 * @param content compose函数
 */
@Composable
fun refreshContent(content: @Composable () -> Unit) {

}