package com.example.pokemonapi.model.datasource.local

import com.example.pokemonapi.model.data.Pokemon

object LocalData {
    fun createDataSet(): ArrayList<Pokemon> {
        val list = arrayListOf(
            Pokemon(
                "Bukayo Saka",
                "RW"
            ),
            Pokemon(
                "Bukayo Saka",
                "RW"
            ), Pokemon(
                    "Bukayo Saka",
            "RW"
        ))

        return list
    }
}