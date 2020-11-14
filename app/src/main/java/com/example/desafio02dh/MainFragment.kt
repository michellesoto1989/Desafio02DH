package com.example.desafio02dh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.desafio.digitalhousefoods.domain.Restaurante
import com.desafio.digitalhousefoods.domain.RestauranteAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.util.ArrayList
import com.desafio.digitalhousefoods.R
import com.example.desafio02dh.domain.RestaurantAdapter
import kotlinx.android.synthetic.main.fragment_restaurante.*


class MainFragment : Fragment(), RestaurantAdapter.OnClickRestauranteListener {
    private val listaDeRestaurantes = getRestaurantes(3)
    private val adapter = RestaurantAdapter(listaDeRestaurantes, this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val recy = view.findViewById<RecyclerView>(R.id.rvRestaurantes)
        recy.adapter = adapter
        recy.setHasFixedSize(true)


        return view
    }

    companion object{
        fun newInstance() = MainFragment()
    }


    fun getRestaurantes(size: Int): ArrayList<Restaurant> {
        val lista = ArrayList<Restaurant>()

        for (i in 0..size){
            when(i%4){
                0 -> lista.add(Restaurant(R.drawable.image1, "Tony Roma's", "Avenida Lavandisca, 717 - Indianópolis, São Paulo", "Fecha ás 22:00"))
                1 -> lista.add(Restaurant(R.drawable.image4, "Aoyama - Moema", "Alameda Dos Arapanés, 532 - Moema", "Fecha ás 00:00"))
                2 -> lista.add(Restaurant(R.drawable.image5, "Outback - Moema", "Av. Moaci, 187 - Moema, São Paulo", "Fecha ás 00:00"))
                3 -> lista.add(Restaurant(R.drawable.image3, "Sí Senõr!", "Alameda juaperi, 626 - Moema", "Fecha ás 01:00"))
            }
        }

        return lista
    }

    override fun OnClickRestaurante(position: Int) {
        val restaurante = listaDeRestaurantes.get(position)
        adapter.notifyItemChanged(position)

        val bundle = bundleOf("amount" to restaurant.img, "nome" to restaurant.nome)




        findNavController().navigate(R.id.action_mainFragment_to_restaurantFragment, bundle)

    }


}