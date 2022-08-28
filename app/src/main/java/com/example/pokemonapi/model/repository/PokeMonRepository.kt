package com.example.pokemonapi.model.repository

import com.example.pokemonapi.model.data.PokemonResult
import com.example.pokemonapi.model.datasource.remote.api.PokemonApiService

class PokeMonRepository(
    private val pokemonApiService: PokemonApiService
) {
    suspend fun getAllPokemon() : PokemonResult{
        return pokemonApiService.getPokemon()
    }
}