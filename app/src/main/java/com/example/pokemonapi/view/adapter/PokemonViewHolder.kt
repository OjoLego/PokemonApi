package com.example.pokemonapi.view.adapter

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapi.databinding.CardviewBinding
import com.example.pokemonapi.model.data.Pokemon
import com.example.pokemonapi.model.data.PokemonDTO
import com.example.pokemonapi.model.data.datafile.PokeMonData

private const val TAG = "PokemonViewHolder"
class PokemonViewHolder(val binding: CardviewBinding):RecyclerView.ViewHolder(binding.root){
    val pokemonName = binding.pokemonName
    val pokemonNumber = binding.pokemonNumber

    fun bind(pokemon : Pokemon){
        Log.d(TAG, pokemon.name)
        pokemonNumber.setText(pokemon.url.takeLast(2))
        pokemonName.setText(pokemon.name)

    }
}