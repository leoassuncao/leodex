package br.com.leonardo.pokedex.flow.pokemonDetail

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.leonardo.pokedex.R
import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.api.model.PokemonDetail
import br.com.leonardo.pokedex.flow.main.ILoadingPresenter
import br.com.leonardo.pokedex.utils.TypeUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

class PokemonDetailActivity : AppCompatActivity() {

    private val detailViewModel by viewModel<PokemonDetailViewModel>()
    private lateinit var pokemon: Pokemon

    companion object {
        const val EXTRA_POKEMON = "EXTRA_POKEMON"

        fun startActivity(pokemon: Pokemon, context: Context) {
            val intent = Intent(context, PokemonDetailActivity::class.java)
            intent.putExtra(EXTRA_POKEMON, pokemon)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)
        pokemon = intent.getSerializableExtra(EXTRA_POKEMON) as Pokemon
        detailViewModel.getPokemon(pokemon.getNumber(pokemon.url))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setupObservables()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun setupObservables() {
        detailViewModel.pokemonResponse?.observe(this, ::populateUi)
    }

    private fun populateUi(pokemonDetail: PokemonDetail) {
        Glide.with(pokemonDetailSprite.context)
            .load(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${pokemonDetail.id}.png"
            )
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(pokemonDetailSprite)
        pokemonDetailName.text = pokemonDetail.name.capitalize()
        pokemonDetailWeight.text = pokemonDetail.weight.toString() + "KG"
        pokemonDetailHeight.text = pokemonDetail.height.toString() + "M"
        pokemonDetailProgressHp.progress = pokemonDetail.stats.first().baseStat.toFloat()
        pokemonDetailProgressHp.labelText = pokemonDetail.stats.first().baseStat.toString()
        pokemonDetailProgressAttack.progress = pokemonDetail.stats[1].baseStat.toFloat()
        pokemonDetailProgressAttack.labelText = pokemonDetail.stats[1].baseStat.toString()
        pokemonDetailProgressDefense.progress = pokemonDetail.stats[2].baseStat.toFloat()
        pokemonDetailProgressDefense.labelText = pokemonDetail.stats[2].baseStat.toString()
        pokemonDetailProgressSpecialAttack.progress = pokemonDetail.stats[3].baseStat.toFloat()
        pokemonDetailProgressSpecialAttack.labelText = pokemonDetail.stats[3].baseStat.toString()
        pokemonDetailProgressSpecialDefense.progress = pokemonDetail.stats[4].baseStat.toFloat()
        pokemonDetailProgressSpecialDefense.labelText = pokemonDetail.stats[5].baseStat.toString()
        pokemonDetailProgressSpeed.progress = pokemonDetail.stats[5].baseStat.toFloat()
        pokemonDetailProgressSpeed.labelText = pokemonDetail.stats[5].baseStat.toString()
        pokemonDetailProgressExperience.progress = pokemonDetail.experience.toFloat()
        pokemonDetailProgressExperience.labelText = pokemonDetail.experience.toString()

        populateTypes(pokemonDetail.types)
    }

    private fun populateTypes(types: List<PokemonDetail.Types>) {
        pokemonDetailHeader.setBackgroundColor(
            ContextCompat.getColor(
                this,
                TypeUtils.getTypeColor(types.first().type.typeName)
            )
        )
        supportActionBar?.setBackgroundDrawable(
            ColorDrawable(
                ContextCompat.getColor(
                    this,
                    TypeUtils.getTypeColor(types.first().type.typeName)
                )
            )
        )
        if (types.size == 2) {
            pokemonDetailTypeUnique.visibility = View.GONE
            pokemonDetailTypeOne.visibility = View.VISIBLE
            pokemonDetailTypeTwo.visibility = View.VISIBLE
            pokemonDetailTypeOne.text = types.first().type.typeName
            pokemonDetailTypeTwo.text = types.last().type.typeName
            pokemonDetailTypeOne.setRibbonColor(
                ContextCompat.getColor(
                    this,
                    TypeUtils.getTypeColor(types.first().type.typeName)
                )
            )
            pokemonDetailTypeTwo.setRibbonColor(
                ContextCompat.getColor(
                    this,
                    TypeUtils.getTypeColor(types.last().type.typeName)
                )
            )
        } else {
            pokemonDetailTypeUnique.visibility = View.VISIBLE
            pokemonDetailTypeOne.visibility = View.GONE
            pokemonDetailTypeTwo.visibility = View.GONE
            pokemonDetailTypeUnique.text = types.first().type.typeName
            pokemonDetailTypeUnique.setRibbonColor(
                ContextCompat.getColor(
                    this,
                    TypeUtils.getTypeColor(types.first().type.typeName)
                )
            )

        }
    }
}