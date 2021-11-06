package com.mpfcoding.podedex.api.repository

import android.util.Log
import com.mpfcoding.podedex.api.model.PokemonsApiResult
import com.mpfcoding.podedex.api.model.SinglePokemonApiResult
import com.mpfcoding.podedex.api.service.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

//        call.enqueue(object : Callback<PokemonsApiResult>{
//            override fun onResponse(
//                call: Call<PokemonsApiResult>,
//                response: Response<PokemonsApiResult>) {
//                Log.e("POKEMON_API", "Pokemon list loaded")
//
//                if (response.isSuccessful){
//                    val body = response.body()
//
//                    body?.results.let {
//
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<PokemonsApiResult>, t: Throwable) {
//                Log.e("POKEMON_API", "Error loading pokemon list.", t)
//            }
//        })
    }
}