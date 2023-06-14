package com.example.pedidosapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityEnlatadosBinding
import com.example.pedidosapp.databinding.FragmentHomeBinding
import com.example.pedidosapp.databinding.FragmentPedidosBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PedidosFragment : Fragment() {


    private lateinit var adapterpedido : AdapterPedidoUsuario
    private lateinit var pedidoList : ArrayList<ItemPedido>
    val db = FirebaseFirestore.getInstance()


    private var _binding : FragmentPedidosBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentPedidosBinding.inflate(inflater, container, false)


        llamarrecyclerview()

        return binding.root

    }

    private fun llamarrecyclerview() {

        val user = FirebaseAuth.getInstance().currentUser       //para obtener el usuario actual
        val correoElectronico = user?.email

        pedidoList = ArrayList()
        adapterpedido = AdapterPedidoUsuario(pedidoList)
        db.collection("Pedidos")
            .whereEqualTo("Email del destinatario", correoElectronico)
            .get()
            .addOnSuccessListener { documets ->
                for(document in documets){
                    val wallItem = document.toObject(ItemPedido::class.java)
                    wallItem.idPedido = document.id
                    wallItem.fechaPedido = document["Fecha del pedido"].toString()
                    wallItem.tipoPagoPedido = document["Tipo de pago"].toString()
                    wallItem.estadoEntregaPedido = document["Estado de la entrega"].toString()

                    binding.recyclerssPedido.adapter = adapterpedido
                    binding.recyclerssPedido.layoutManager = LinearLayoutManager(context)
                    pedidoList.add(wallItem)
                }
            }

    }

}