package com.mpfcoding.podedex.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mpfcoding.podedex.api.repository.PokemonRepository
import com.mpfcoding.podedex.domain.Pokemon
import com.mpfcoding.podedex.utils.Constants

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
                    .replace(Constants.POKEMON_API_REPLACE, "")
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