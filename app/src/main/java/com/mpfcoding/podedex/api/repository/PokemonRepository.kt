package com.mpfcoding.podedex.api.repository

import com.mpfcoding.podedex.api.model.PokemonsApiResult
import com.mpfcoding.podedex.api.model.SinglePokemonApiResultDescription
import com.mpfcoding.podedex.api.service.PokemonService
import com.mpfcoding.podedex.domain.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {

    private val service: PokemonService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 151): PokemonsApiResult? {
        val call = service.listPokemons(limit)

        return call.execute().body()
    }

    fun getPokemons(number: Int): SinglePokemonApiResultDescription? {
        val call = service.getPokemon(number)

        return call.execute().body()
    }
}