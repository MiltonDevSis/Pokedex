package com.mpfcoding.podedex.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpfcoding.podedex.api.repository.PokemonRepository
import com.mpfcoding.podedex.databinding.ActivityMainBinding
import com.mpfcoding.podedex.domain.Pokemon
import com.mpfcoding.podedex.domain.PokemonType
import com.mpfcoding.podedex.presentation.adapter.PokemonAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView

//        val pok = Pokemon(
//                "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/009.png",
//                9,
//                "Pikachu",
//            "",
//                listOf(
//                    PokemonType("Earth"),
//                    PokemonType("Teste")
//                )
//            )

//        val pokemons = listOf(pok, pok, pok)

        Thread{
            loadPokemons()
        }.start()
    }

    private fun loadPokemons() {

        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {
            val layoutManager = LinearLayoutManager(this)

            recyclerView.post {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = PokemonAdapter(it)
            }
        }
    }
}