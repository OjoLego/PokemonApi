package com.example.pokemonapi.model.datasource.remote.api

import com.example.pokemonapi.model.data.PokemonResult
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET

interface PokemonApiService {

    @GET("pokemon")
    suspend fun getPokemon() : PokemonResult

    @DELETE("{/id}")
    suspend fun deletePoke(id : Int)
}