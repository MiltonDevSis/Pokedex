package com.mpfcoding.podedex.domain

import java.util.*

class Pokemon(
    val number: Int,
    val name: String,
    val types: List<PokemonType>
){
    val formatterName = name.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }
    val formatterNumber = number.toString().padStart(3, '0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formatterNumber.png"
}

