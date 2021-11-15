package com.mpfcoding.podedex.utils

import android.content.Context
import androidx.core.content.ContextCompat
import com.mpfcoding.podedex.R

object Constants {

    const val POKEMON_API = "https://pokeapi.co/api/v2/"
    const val POKEMON_API_REPLACE = "${POKEMON_API}pokemon/"
}

object PokemonTypesColor {
    const val WATER = "water"
    const val FIRE = "fire"
    const val GRASS = "grass"
    const val POISON = "poison"
    const val FLYING = "flying"
    const val BUG = "bug"
    const val NORMAL = "normal"
    const val ELECTRIC = "electric"
    const val GROUND = "ground"
    const val FAIRY = "fairy"
    const val FIGHTING = "fighting"
    const val PSYCHIC = "psychic"
    const val ROCK = "rock"
    const val STEEL = "steel"
    const val ICE = "ice"
    const val GHOST = "ghost"
    const val DRAGON = "dragon"
    const val DARK = "dark"
}

object PokemonColorTypes{
    fun getPokemonColorType(context: Context, type: String): Int{
        return when(type){
            PokemonTypesColor.POISON -> ContextCompat.getColor(context, R.color.Type_poison)
            PokemonTypesColor.GRASS -> ContextCompat.getColor(context, R.color.Type_grass)
            PokemonTypesColor.FIRE -> ContextCompat.getColor(context, R.color.Type_fire)
            PokemonTypesColor.WATER -> ContextCompat.getColor(context, R.color.Type_water)
            PokemonTypesColor.BUG -> ContextCompat.getColor(context, R.color.Type_bug)
            PokemonTypesColor.NORMAL -> ContextCompat.getColor(context, R.color.Type_normal)
            PokemonTypesColor.FIGHTING -> ContextCompat.getColor(context, R.color.Type_fighting)
            PokemonTypesColor.FAIRY -> ContextCompat.getColor(context, R.color.Type_fairy)
            PokemonTypesColor.PSYCHIC -> ContextCompat.getColor(context, R.color.Type_psychic)
            PokemonTypesColor.ELECTRIC -> ContextCompat.getColor(context, R.color.Type_eletric)
            PokemonTypesColor.ICE -> ContextCompat.getColor(context, R.color.Type_ice)
            PokemonTypesColor.GHOST -> ContextCompat.getColor(context, R.color.Type_ghost)
            PokemonTypesColor.ROCK -> ContextCompat.getColor(context, R.color.Type_rock)
            PokemonTypesColor.DARK -> ContextCompat.getColor(context, R.color.Type_dark)
            PokemonTypesColor.STEEL -> ContextCompat.getColor(context, R.color.Type_steel)
            PokemonTypesColor.FLYING -> ContextCompat.getColor(context, R.color.Type_flying)
            PokemonTypesColor.DRAGON -> ContextCompat.getColor(context, R.color.Type_dragon)
            PokemonTypesColor.GROUND -> ContextCompat.getColor(context, R.color.Type_ground)
            else -> ContextCompat.getColor(context, R.color.black)
        }
    }
}