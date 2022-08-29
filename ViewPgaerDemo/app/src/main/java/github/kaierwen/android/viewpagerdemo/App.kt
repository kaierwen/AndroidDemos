package github.kaierwen.android.viewpagerdemo

import android.app.Application
import timber.log.Timber


/**
 * @author qiaofeng
 * @since 2022/6/2
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}