package com.mpfcoding.podedex

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.mpfcoding.podedex.api.model.SinglePokemonApiResultDescription
import com.mpfcoding.podedex.databinding.ActivityPokemonBinding
import com.mpfcoding.podedex.utils.PokemonColorTypes
import com.mpfcoding.podedex.utils.PokemonTypesColor

class PokemonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokemonBinding
    val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        populaPokemon()
    }

    private fun populaPokemon() {
        val result = gson.fromJson(
            intent.getStringExtra("Pokemon"),
            SinglePokemonApiResultDescription::class.java
        )

//        Glide.with(itemView.context)
//            .load(it.imageUrl)
//            .into(imagePokemon)

        if (result != null) {
            binding.singleTextPokemonName.text = result.name
            binding.singleTextType1.text = result.types[0].type.name.capitalize()
            val typeName = result.types[0].type.name

            var color = PokemonColorTypes.getPokemonColorType(applicationContext, typeName)
            binding.singleTextType1.setBackgroundColor(color)

            if (result.types.size > 1) {
                val typeName2 = result.types[1].type.name
                color = PokemonColorTypes.getPokemonColorType(applicationContext, typeName2)
                binding.singleTextType2.setBackgroundColor(color)
                binding.singleTextType1.visibility = View.VISIBLE
                binding.singleTextType2.text = result.types[1].type.name.capitalize()
            } else {
                binding.singleTextType2.visibility = View.GONE
            }
        }
    }
}