package br.com.leonardo.pokedex

import android.os.Build
import android.os.Looper
import android.view.View
import androidx.lifecycle.LiveData
import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.flow.pokemonList.MainActivity
import br.com.leonardo.pokedex.flow.pokemonList.MainViewModel
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode


/**
 * @author Leonardo Assunção
 * @since 24/02/21
 **/

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
@LooperMode(LooperMode.Mode.PAUSED)
class MainActivityTest {

    private lateinit var activity: MainActivity
    private lateinit var activityController: ActivityController<MainActivity>

    @MockK
    private var viewModel = mockk<MainViewModel>()

    @MockK
    private var pokemonResponse = mockk<LiveData<List<Pokemon>>>()

    @Before
    fun setUp() {

        every { (viewModel.pokemonResponse) } returns pokemonResponse

        activityController = Robolectric.buildActivity(MainActivity::class.java)
        activity = activityController.get()

        activityController.create()
        activity.setTestViewModel(viewModel)

        activityController.start()

    }

    @Test
    fun `has show recycler view on create`() {
        shadowOf(Looper.getMainLooper()).idle()
        assertEquals(View.VISIBLE, activity.rv_pokemons.visibility)
    }
}