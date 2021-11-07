package com.mpfcoding.podedex.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mpfcoding.podedex.api.repository.PokemonRepository
import com.mpfcoding.podedex.domain.Pokemon

class MainViewModel : ViewModel() {

    private val _pokemons = MutableLiveData<List<Pokemon?>>()
    var pokemons = _pokemons

    init {
        Thread {
            loadPokemons()
        }.start()
    }


    private fun loadPokemons() {

        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            pokemons.postValue(it.map { pokemonResult ->
                val number = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/", "")
                    .replace("/", "").toInt()

                val pokemonApiResult = PokemonRepository.getPokemons(number)

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map { type ->
                            type.type
                        }
                    )
                }
            })
        }
    }
}