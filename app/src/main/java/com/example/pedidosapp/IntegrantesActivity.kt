package com.example.pedidosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityBebidasBinding
import com.example.pedidosapp.databinding.ActivityIntegrantesBinding
import com.google.firebase.firestore.FirebaseFirestore

class IntegrantesActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    private lateinit var adapterintegrante : AdapterIntegrantes
    private lateinit var binding : ActivityIntegrantesBinding
    private lateinit var integrateList : ArrayList<ItemIntegrante>


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityIntegrantesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llamarrecyclerview()

    }

    private fun llamarrecyclerview() {

        integrateList = ArrayList()
        adapterintegrante = AdapterIntegrantes(integrateList)

        db.collection("Integrantes")
            .get()
            .addOnSuccessListener { documets ->
                for(document in documets){
                    val wallItem = document.toObject(ItemIntegrante::class.java)

                    wallItem.idIntegrante = document.id
                    wallItem.nomIntegrante = document["Nombre"].toString()
                    wallItem.telfIntegrante = document["Telefono"].toString().toInt()
                    wallItem.rolIntegrante = document["Rol"].toString()
                    wallItem.urlIntegrante = document["foto"].toString()


                    binding.recyclerssIntegrantes.adapter = adapterintegrante
                    binding.recyclerssIntegrantes.layoutManager = LinearLayoutManager(this)
                    integrateList.add(wallItem)
                }
            }

    }
}