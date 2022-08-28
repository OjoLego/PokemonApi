package com.example.pokemonapi.model.data

data class PokemonDTO(
    var abilities : List<Ability>,
    val base_experience : Int,
    val form : List<PokemonForm>,
    val game_indices : List<Leo>,
    val height : Int
)

data class Ability(
    val ability: Pojo,
    val is_hidden : Boolean,
    val slot : Int
)

data class Pojo(
    val name : String,
    val url : String
)

data class PokemonForm(
    val name : String,
    val url : String
)

data class Leo(
    val game_index : Int,
    val version : List<Leon>
)

data class Leon(
    val name : String,
    val url : String
)