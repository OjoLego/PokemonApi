package com.example.pokemonapi.view.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapi.R
import com.example.pokemonapi.databinding.ActivityMainBinding
import com.example.pokemonapi.model.data.Pokemon
import com.example.pokemonapi.model.datasource.local.LocalData
import com.example.pokemonapi.view.adapter.PokemonAdapter
import com.example.pokemonapi.viewmodel.MainViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()

    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        getDataClickListener()
        observeViewModel()
    }

    private fun getDataClickListener(){
        binding.mainActivityButton.setOnClickListener {
           mainViewModel.getPokemon()
        }
    }

    private fun initRecyclerView(list : List<Pokemon> = emptyList() ){

        if(list.isEmpty()){
            binding.mainActivityRecyclerView.visibility = GONE
            binding.mainActivityNoData.visibility = VISIBLE
        }else {
            binding.mainActivityRecyclerView.visibility = VISIBLE
            binding.mainActivityNoData.visibility = GONE

            binding.mainActivityRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                pokemonAdapter = PokemonAdapter(list)
                adapter = pokemonAdapter
            }
        }
    }

    private fun observeViewModel(){
        mainViewModel.pokemonList.observe(this) {
            initRecyclerView(it)
        }
    }
}