package com.mpfcoding.podedex.api.model

data class SinglePokemonApiResultDescription(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>
)
