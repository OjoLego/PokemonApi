package com.example.pokemonapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapi.model.data.Pokemon
import com.example.pokemonapi.model.datasource.remote.api.PokeMonRetrofit
import com.example.pokemonapi.model.repository.PokeMonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"
class MainViewModel : ViewModel() {

    private val retrofitService = PokeMonRetrofit.pokeRetrofit
    private val pokeRepository = PokeMonRepository(retrofitService)
    private var _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList : LiveData<List<Pokemon>> = _pokemonList

    fun getPokemon(){
         viewModelScope.launch(Dispatchers.IO) {
             val res = pokeRepository.getAllPokemon()
             Log.d(TAG, res.toString())
             _pokemonList.postValue(res.results)
         }
    }
}