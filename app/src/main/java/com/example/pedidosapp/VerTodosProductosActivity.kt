package com.example.pedidosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityAdminBinding
import com.example.pedidosapp.databinding.ActivityVerTodosProductosBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.ArrayList

class VerTodosProductosActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    private lateinit var adapterproduct : Adapterproductos
    private lateinit var binding : ActivityVerTodosProductosBinding
    private lateinit var producList : ArrayList<ItemProduct>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerTodosProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llamarrecyclerview()
    }

    private fun llamarrecyclerview() {

        producList = ArrayList()
        adapterproduct = Adapterproductos(producList)
        db.collection("Productos")
            .orderBy("Nombre")
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

                    binding.recyclerssProduct.adapter = adapterproduct
                    binding.recyclerssProduct.layoutManager = LinearLayoutManager(this)
                    producList.add(wallItem)
                }
            }

    }
}