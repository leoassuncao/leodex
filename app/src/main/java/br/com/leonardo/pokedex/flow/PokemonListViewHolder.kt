package br.com.leonardo.pokedex.flow

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardo.pokedex.R
import br.com.leonardo.pokedex.api.model.Pokemon
import br.com.leonardo.pokedex.flow.pokemonDetail.PokemonDetailActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

class PokemonListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.main_pokemon_list_item, parent, false)) {
    private var pokemonName: TextView? = null
    private var pokemonCard: CardView? = null
    private var pokemonSprite: ImageView
    private var pokemonNumber: TextView? = null


    init {
        pokemonName = itemView.findViewById(R.id.pokemonName)
        pokemonCard = itemView.findViewById(R.id.pokemonCard)
        pokemonSprite = itemView.findViewById(R.id.pokemonSprite)
        pokemonNumber = itemView.findViewById(R.id.pokemonNumber)

    }

    fun bind(pokemon: Pokemon) {
        val number = pokemon.getNumber(pokemon.url)
        pokemonName?.text = pokemon.name
        pokemonNumber?.text = number.toString()
        pokemonCard?.setOnClickListener {
            pokemonName?.context?.let { it1 -> PokemonDetailActivity.startActivity(pokemon, it1) }
        }

        Glide.with(pokemonSprite.context)
            .load(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$number.png"
            )
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(pokemonSprite)
    }



}