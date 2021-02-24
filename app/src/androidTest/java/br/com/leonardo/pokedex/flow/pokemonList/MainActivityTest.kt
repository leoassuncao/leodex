package br.com.leonardo.pokedex.flow.pokemonList

/**
 * @author Leonardo Assunção
 * @since 23/02/21
 **/


import android.os.SystemClock
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import br.com.leonardo.pokedex.CustomAssertions.Companion.hasItemCount
import br.com.leonardo.pokedex.CustomMatchers.Companion.withItemCount
import br.com.leonardo.pokedex.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun countPokemon() {
        SystemClock.sleep(2000)
        onView(withId(R.id.rv_pokemons))
            .check(matches(withItemCount(964)))
    }

    @Test
    fun countPokemonWithViewAssertion() {
        SystemClock.sleep(2000)
        onView(withId(R.id.rv_pokemons))
            .check(hasItemCount(964))
    }

    @Test
    fun onClickRecyclerView() {
        SystemClock.sleep(2000)
        onView(withId(R.id.rv_pokemons)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(1, ViewActions.click()))
        Espresso.pressBack()
    }
}