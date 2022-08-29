package github.kaierwen.android.viewpager2lazy

import android.app.Application
import timber.log.Timber

/**
 *
 * @author kevinzhang
 * @since 2021/8/25
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}