package com.example.desafio02dh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.fragment_detail.view.buton_voltar_prato as buton_voltar_prato


class DetailFragment : Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)

        view.buton_voltar_prato.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_restauranteFragment)
        }



        return view
    }


}