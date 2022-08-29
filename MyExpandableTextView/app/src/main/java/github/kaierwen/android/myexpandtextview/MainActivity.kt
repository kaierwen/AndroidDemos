package github.kaierwen.android.myexpandtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.ms.square.android.expandabletextview.ExpandableTextView
import github.kaierwen.android.myexpandtextview.expand.Utils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv1).apply {
            Utils.toggleEllipsize(
                this,
                "阿搜到加发烧是伽伽；啊就是关联空间奥斯卡级奥数和欧沃尔阿GIA和上高伤感 哦啊哦啊书哦钙素阿搜狗uasgiaiouweioqhtq 雄爱好个；OAhi嘎哦i爱us给对方个uwibbasdi 阿速达发IUIG阿速达 安徽省都发顺丰"
            )
        }
        findViewById<ExpandableTextView>(R.id.expand_text_view).apply {
            text = "卡迪夫拉客奥维卡卡卡点击附件跑去恶违法你女阿道夫 啊但是放票时间佛牌UIi哈急啊好地方和哦i奥斯迪of和哦你按时就是滴哦急刹我偶会哦啊爱哦是加速 is导航覅OA算法是爱仕达覅OA深渊法师已送达易发生偶爱速度覅偶奥司法爱爱速递哦"
        }
    }
}