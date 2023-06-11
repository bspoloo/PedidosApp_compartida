package com.example.pedidosapp

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityBebidasBinding
import com.example.pedidosapp.databinding.FragmentBuscadorBinding
import com.example.pedidosapp.databinding.FragmentHomeBinding
import com.example.pedidosapp.databinding.FragmentPerfilBinding
import com.google.firebase.firestore.FirebaseFirestore

class BuscadorFragment : Fragment() {

    val db = FirebaseFirestore.getInstance()

    private lateinit var adapterproduct : AdapterTipoProductos
    private lateinit var producList : ArrayList<ItemProduct>

    private var _binding : FragmentBuscadorBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBuscadorBinding.inflate(inflater, container, false)


        binding.buttonBuscar.setOnClickListener {
            llamarrecyclerview()
        }

        llamarrecyclerview()

        return binding.root
    }


    private fun llamarrecyclerview() {

        producList = ArrayList()
        adapterproduct = AdapterTipoProductos(producList)
        db.collection("Productos")
            .whereEqualTo("Nombre",binding.DatoBuscarNombre.text.toString())
            .get()
            .addOnSuccessListener { documets ->
                for(document in documets){
                    val wallItem = document.toObject(ItemProduct::class.java)
                    wallItem.idProduct = document.id

                    wallItem.nomProduct = document["Nombre"].toString()
                    wallItem.descProduct = document["Descripcion"].toString()
                    wallItem.tipProduct = document["Tipo"].toString()
                    wallItem.marcProduct = document["Marca"].toString()
                    wallItem.uniProduct = document["Unidad"].toString()
                    wallItem.preProduct = document["Precio"].toString().toFloat()
                    wallItem.imgProduct = document["Imagen del producto"].toString()

                    binding.recyclerssTipoProduct.adapter = adapterproduct
                    binding.recyclerssTipoProduct.layoutManager = LinearLayoutManager(context)
                    producList.add(wallItem)
                }
            }

    }
}



