package github.kaierwen.android.basicscodelab

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sample()
        }
    }
}

@Composable
fun Sample() {
    val context = LocalContext.current
    Column {
        Text(text = "引用MyApp组件")
        Text(text = stringResource(id = R.string.hello))
        MyApp()
        Button(onClick = {
            context.startActivity(Intent(context, MainActivity2::class.java))
        }) {
            Text(text = "跳转到Activity2")
        }
    }
}

/**
 * 默认预览
 */
@Preview(showBackground = true)
@Composable
fun Preview() {
    Sample()
}

/**
 * 默认预览
 */
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewNight() {
    Sample()
}

/**
 * 中文预览
 */
@Preview(showBackground = true, locale = "zh-rCN")
@Composable
fun Preview_zh_rCN() {
    Sample()
}

/**
 * 中文预览
 */
@Preview(showBackground = true, locale = "zh-rCN", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewNight_zh_rCN() {
    Sample()
}