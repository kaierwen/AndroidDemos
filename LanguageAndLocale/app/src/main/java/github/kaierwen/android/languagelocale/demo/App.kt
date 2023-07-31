package github.kaierwen.android.languagelocale.demo

import android.content.Context
import github.kaierwen.android.languagelocale.LanguageLocaleApp
import timber.log.Timber

class App: LanguageLocaleApp(debugMode = true) {

    override fun attachBaseContext(base: Context) {
        Timber.d("attachBaseContext() , base=$base")
        super.attachBaseContext(base)
    }
}