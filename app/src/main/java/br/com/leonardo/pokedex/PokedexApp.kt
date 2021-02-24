package br.com.leonardo.pokedex

import androidx.multidex.BuildConfig
import br.com.leonardo.pokedex.di.*
import androidx.multidex.MultiDexApplication
import kotlinx.coroutines.FlowPreview
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

@FlowPreview
@ExperimentalStdlibApi
class PokedexApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        setupKoin()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@PokedexApp)
            modules(
                listOf(
                    apiModule,
                    networkModule,
                    modelModule,
                    presenterModule,
                    serviceModule,
                    viewModelModule
                )
            )
        }
    }
}