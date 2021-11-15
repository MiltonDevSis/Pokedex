package com.mpfcoding.podedex.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mpfcoding.podedex.R
import com.mpfcoding.podedex.databinding.PokemonItemBinding
import com.mpfcoding.podedex.domain.Pokemon
import com.mpfcoding.podedex.utils.PokemonTypesColor

class PokemonViewHolder(
    private val binding: PokemonItemBinding,
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    override fun onClick(p0: View?) {
        val position = adapterPosition

        when(p0?.id){

        }
    }

    @SuppressLint("SetTextI18n")
    fun bind(context: Context, item: Pokemon?) = with(itemView) {
        val imagePokemon = binding.imagePokemon
        val pokemonNumber = binding.textPokemonNumber
        val pokemonName = binding.textPokemonName
        val pokemonType1 = binding.textType1
        val pokemonType2 = binding.textType2

        item?.let {
            Glide.with(itemView.context)
                .load(it.imageUrl)
                .into(imagePokemon)

            pokemonNumber.text = "Nº ${item.formatterNumber}"
            pokemonName.text = item.formatterName
            val typeName = item.types[0].name
            pokemonType1.text = typeName
            val color = getPokemonColorType(context, typeName)
            pokemonType1.setBackgroundColor(color)

            if (item.types.size > 1){
                pokemonType2.visibility = View.VISIBLE
                pokemonType2.text = item.types[1].name
            }else{
                pokemonType2.visibility = View.GONE
            }
        }
    }

    private fun getPokemonColorType(context: Context, type: String): Int{
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