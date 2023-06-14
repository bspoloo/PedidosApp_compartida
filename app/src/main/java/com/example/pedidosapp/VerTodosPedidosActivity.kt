package com.example.pedidosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityVerTodosPedidosBinding
import com.google.firebase.firestore.FirebaseFirestore


class VerTodosPedidosActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()

    private lateinit var adapterpedido : AdapterPedidos
    private lateinit var binding : ActivityVerTodosPedidosBinding
    private lateinit var pedidosList : ArrayList<ItemPedido>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerTodosPedidosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        llamarrecyclerview()
    }

    private fun llamarrecyclerview() {

        pedidosList = ArrayList()
        adapterpedido = AdapterPedidos(pedidosList)
        db.collection("Pedidos")
            .get()
            .addOnSuccessListener { documets ->
                for(document in documets){
                    val wallItem = document.toObject(ItemPedido::class.java)

                    wallItem.idPedido = document.id
                    wallItem.nomProPedido = document["Nombre del Producto"].toString()
                    wallItem.tipPedido = document["Tipo del Prodducto"].toString()
                    wallItem.marcPedido = document["Marca del Producto"].toString()
                    wallItem.uniPedido = document["Unidad del Producto"].toString()
                    wallItem.ubiPedido = document["Ubicacion"].toString()
                    wallItem.nomDesPedido = document["Nombre del destinatario"].toString()
                    wallItem.prePedido = document["Precio"].toString().toFloat()
                    wallItem.cantPedido = document["Cantidad"].toString().toInt()
                    wallItem.totalPagoPedido = document["Total a pagar"].toString()
                    wallItem.EmailDestPedido = document["Email del destinatario"].toString()
                    wallItem.numTelfPedido = document["Numero de telefono"].toString().toInt()
                    wallItem.fechaPedido = document["Fecha del pedido"].toString()
                    wallItem.tipoPagoPedido = document["Tipo de pago"].toString()
                    wallItem.estadoEntregaPedido = document["Estado de la entrega"].toString()

                    binding.recyclerssPedidos.adapter = adapterpedido
                    binding.recyclerssPedidos.layoutManager = LinearLayoutManager(this)
                    pedidosList.add(wallItem)
                }
            }

    }
}