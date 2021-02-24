package br.com.leonardo.pokedex.flow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardo.pokedex.api.model.Pokemon


/**
 * @author Leonardo Assunção
 * @since 22/02/21
 **/

class PokemonListAdapter(private val list: List<Pokemon>)
    : RecyclerView.Adapter<PokemonListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PokemonListViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        val pokemon: Pokemon = list[position]
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int = list.size

}