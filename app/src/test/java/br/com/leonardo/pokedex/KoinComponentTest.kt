package br.com.leonardo.pokedex

import br.com.leonardo.pokedex.di.*
import io.mockk.unmockkAll
import kotlinx.coroutines.FlowPreview
import org.junit.AfterClass
import org.junit.BeforeClass
import org.koin.core.KoinComponent
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

/**
 * @author Leonardo Assunção
 * @since 24/02/21
 **/

abstract class KoinComponentTest : KoinComponent {

    companion object {

        @FlowPreview
        @BeforeClass
        @JvmStatic
        fun init() {
            startKoin {
                modules(
                    listOf(
                        apiMockModule,
                        modelMockModule,
                        presenterMockModule,
                        serviceMockModule,
                        viewModelMockModule
                    )
                )
            }
        }

        @AfterClass
        @JvmStatic
        fun afterAll() {
            // Re-assigns transformation of object to original state prior to mock. }
            unmockkAll()
            stopKoin()
        }
    }
}