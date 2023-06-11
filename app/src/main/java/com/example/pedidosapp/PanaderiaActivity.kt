package com.example.pedidosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityPanaderiaBinding
import com.google.firebase.firestore.FirebaseFirestore

class PanaderiaActivity : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()

    private lateinit var adapterproduct : AdapterTipoProductos
    private lateinit var binding : ActivityPanaderiaBinding
    private lateinit var producList : ArrayList<ItemProduct>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPanaderiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        llamarrecyclerview()
    }
    private fun llamarrecyclerview() {

        producList = ArrayList()
        adapterproduct = AdapterTipoProductos(producList)
        db.collection("Productos")
            .whereEqualTo("Tipo", "Panadería y pastelería")
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
                    binding.recyclerssTipoProduct.layoutManager = LinearLayoutManager(this)
                    producList.add(wallItem)
                }
            }

    }
}