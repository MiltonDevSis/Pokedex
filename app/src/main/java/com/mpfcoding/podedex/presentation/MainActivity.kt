package com.mpfcoding.podedex.presentation

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mpfcoding.podedex.api.repository.PokemonService
import com.mpfcoding.podedex.databinding.ActivityMainBinding
import com.mpfcoding.podedex.domain.Pokemon
import com.mpfcoding.podedex.presentation.adapter.PokemonAdapter
import com.mpfcoding.podedex.presentation.viewmodel.MainViewModel
import com.mpfcoding.podedex.utils.listener.RecyclerItemClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView

        viewModel.pokemons.observe(this,  {
            loadRecyclerView(it)
        })

        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(applicationContext, object :
                RecyclerItemClickListener.OnItemClickListener {

                override fun onItemClick(view: View?, position: Int) {
                    Toast.makeText(applicationContext, "Position ${position + 1}", Toast.LENGTH_LONG).show()
                    Thread {
                        loadPokemon(position)
                    }.start()

                }
            })
        )

    }

    private fun loadPokemon(position: Int){
        val incrementaClick = position + 1
        val pokemon = PokemonService.getPokemons(incrementaClick)
        val teste = pokemon
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>){
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = PokemonAdapter(pokemons, applicationContext)
    }
}