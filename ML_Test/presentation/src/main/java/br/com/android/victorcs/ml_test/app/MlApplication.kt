package br.com.android.victorcs.ml_test.app

import android.app.Application
import br.com.android.victorcs.data.di.DataModule
import br.com.android.victorcs.domain.di.DomainModule
import br.com.android.victorcs.ml_test.BuildConfig
import br.com.android.victorcs.ml_test.app.di.PresenterModule
import org.koin.android.ext.android.startKoin
import timber.log.Timber

/**
 * Application.
 * @author victorcs
 */
class MlApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startTimber()
        startKoin(
            this, listOf(
                DataModule.module,
                DomainModule.module,
                PresenterModule.module
            )
        )
    }

    private fun startTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}