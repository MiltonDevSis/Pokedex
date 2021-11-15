package com.mpfcoding.podedex.api.model

import java.io.Serializable

data class SinglePokemonApiResultDescription(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>
): Serializable
