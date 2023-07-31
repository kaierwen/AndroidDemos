package github.kaierwen.android.languagelocale

import android.app.Application
import android.content.Context
import timber.log.Timber

/**
 * @see https://juejin.cn/post/7046685955230531597#heading-5
 */
open class LanguageLocaleApp(private val debugMode: Boolean? = false) : Application() {

    companion object {
        private val TAG = LanguageLocaleApp::class.java.simpleName
    }

    override fun onCreate() {
        super.onCreate()
        Timber.d("onCreate() , debugMode=$debugMode")
    }

    override fun attachBaseContext(base: Context) {
        // https://github.com/AndroidKnife/RxBus/blob/master/app/src/main/java/com/hwangjr/rxbus/app/AppApplication.java
        if (debugMode == true) {
            Timber.plant(Timber.DebugTree())
//            StrictMode.setVmPolicy(
//                StrictMode.VmPolicy.Builder()
//                    .detectAll()
//                    .penaltyLog()
//                    .build()
//            )
//            var threadPolicyBuilder =
//                StrictMode.VmPolicy.Builder().detectAll().penaltyLog()
//            threadPolicyBuilder.penaltyDeathOnNetwork()
//            StrictMode.setThreadPolicy(threadPolicyBuilder.build())
        }
        Timber.d("attachBaseContext() , baseContext1=$base")
        super.attachBaseContext(base)
        Timber.d("attachBaseContext() , baseContext2=$base")
    }
}