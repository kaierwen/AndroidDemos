package github.kaierwen.android.composebasic

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import github.kaierwen.android.composebasic.ui.theme.MessageCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    NewsList(news = MsgData.messages)
                }
            }
        }
    }
}

data class Message(var title: String, var content: String)

@Composable
fun NewsList(news: List<Message>) {
    LazyColumn {
        items(news.size) { i ->
            Item(bean = news[i])
        }
    }
}

@Composable
fun Item(bean: Message) {
    // `var isExpanded by remember { mutableStateOf(false) }`
    // 报错：Type 'MutableState<Boolean>' has no method 'setValue(Nothing?, KProperty<*>, Boolean)' and thus it cannot serve as a delegate for var (read-write property)
    // 原因分析：声明isExpanded时使用了by关键字，by是kotlin的代理
    // 解决：不用使用by代理
    // `var isExpanded = remember { mutableStateOf(false) }`

    val isExpanded = remember { mutableStateOf(false) }

    Surface(
        shape = MaterialTheme.shapes.medium,
        elevation = 3.dp,
        modifier = Modifier
            .padding(16.dp, 16.dp, 16.dp, 0.dp)
            .clickable { isExpanded.value = !isExpanded.value }
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Icon",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(
                        1.5.dp,
                        MaterialTheme.colors.secondary,// 这里使用的MaterialTheme.colors.secondary，由于在Theme.kt的DarkColorPalette中定义了secondary = Teal200,所以这里的MaterialTheme.colors.secondary其实是使用了Teal200这个颜色
                        CircleShape
                    )
            )
            Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                Text(
                    text = bean.title,
                    softWrap = false,
                    color = MaterialTheme.colors.secondary,
                    overflow = TextOverflow.Visible
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = bean.content,
                    style = MaterialTheme.typography.body1,// 这里使用的MaterialTheme.typography.body1实际是Type.kt文件定义的body1
                    overflow = if (isExpanded.value) TextOverflow.Visible else TextOverflow.Ellipsis,
                    maxLines = if (isExpanded.value) Int.MAX_VALUE else 1,// 修改 maxLines 参数，在默认情况下，只显示一行文本内容
                    modifier = Modifier.animateContentSize() // Composable 大小的动画效果
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = false, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun DefaultPreviewLight() {
    MessageCardTheme {
        NewsList(news = MsgData.messages)
    }
}

@Preview(showBackground = true, showSystemUi = false, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreviewNight() {
    MessageCardTheme {
        NewsList(news = MsgData.messages)
    }
}