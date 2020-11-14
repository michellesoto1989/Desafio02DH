package com.example.desafio02dh.domain


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desafio.digitalhousefoods.R
import com.example.desafio02dh.R
import kotlinx.android.synthetic.main.item_restaurantes.view.*

class RestaurantAdapter<CardRestaurant>(private val listaDeRestaurantes: ArrayList<Restaurant>, val listener: OnClickRestauranteListener): RecyclerView.Adapter<RestauranteAdapter.CardRestaurante>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Any {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return CardRestaurant()
    }

    private fun CardRestaurant() {

    }

    override fun onBindViewHolder(holder: CardRestaurant, position: Int) {
        val currentItem = listaDeRestaurantes[position]

        holder.imgRestaurante.setImageResource(currentItem.img)
        holder.nomeRestaurante.text = currentItem.nome
        holder.addressRestaurante.text = currentItem.address
        holder.horarioRestaurante.text = currentItem.horario

    }

    override fun getItemCount() = listaDeRestaurantes.size

    inner class CardRestaurante(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val imgRestaurante: ImageView = itemView.img_restaurante
        val nomeRestaurante: TextView = itemView.tv_nome_restaurante
        val addressRestaurante: TextView = itemView.tv_address_restaurante
        val horarioRestaurante: TextView = itemView.tv_horario_restaurante

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.OnClickRestaurante(position)
        }
    }

    interface OnClickRestauranteListener{
        fun OnClickRestaurante(position: Int)
    }

    override fun onBindViewHolder(holder: RestauranteAdapter.CardRestaurant, position: Int) {
        TODO("Not yet implemented")
    }

    class RestauranteAdapter {

    }
}