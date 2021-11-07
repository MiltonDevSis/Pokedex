package com.mpfcoding.podedex.api.service

import com.mpfcoding.podedex.api.model.PokemonsApiResult
import com.mpfcoding.podedex.api.model.SinglePokemonApiResultDescription
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number: Int): Call<SinglePokemonApiResultDescription>
}