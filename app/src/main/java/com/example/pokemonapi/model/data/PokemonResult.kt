package com.example.pokemonapi.model.data

data class PokemonResult(
    val count : Int,
    val next : String?,
    val previous : String?,
    val results : List<Pokemon>
)

data class Pokemon(
    val name : String,
    val url : String
)


