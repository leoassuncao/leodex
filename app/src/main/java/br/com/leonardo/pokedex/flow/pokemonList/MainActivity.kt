package br.com.leonardo.pokedex.flow.pokemonList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import br.com.leonardo.pokedex.R
import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.flow.PokemonListAdapter
import br.com.leonardo.pokedex.flow.main.ILoadingPresenter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val activityPresenter: ILoadingPresenter by inject()
    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPresenter.showLoading()
        setContentView(R.layout.activity_main)
        viewModel.getPokemon()
        setupObservables()
    }

    private fun setupObservables() {
        viewModel.pokemonResponse?.observe(this, ::updatePokemonList)

        activityPresenter.loading().observe(this, Observer {
            GlobalScope.launch {
                withContext(Dispatchers.Main) {
                    if (it) {
                        mainLoading.visibility = View.VISIBLE
                    } else {
                        mainLoading.visibility = View.GONE
                    }
                }
            }
        })

    }

    private fun updatePokemonList(pokemonList: List<Pokemon>) {
        rv_pokemons.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = PokemonListAdapter(pokemonList)
        }
        activityPresenter.hideLoading()
    }

}