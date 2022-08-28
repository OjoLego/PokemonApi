package com.example.pokemonapi.model.datasource.remote.api

import com.example.pokemonapi.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokeMonRetrofit {

    private val retrofit : Retrofit.Builder by lazy {
        Retrofit.Builder().baseUrl(
            BASE_URL
        ).addConverterFactory(
            GsonConverterFactory.create()
        )
    }

  val pokeRetrofit : PokemonApiService by lazy {
      retrofit.build().create(PokemonApiService::class.java)
  }
}