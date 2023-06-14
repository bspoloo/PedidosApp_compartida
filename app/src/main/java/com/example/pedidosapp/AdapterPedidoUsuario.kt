package com.example.pedidosapp

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class AdapterPedidoUsuario(private var items: MutableList<ItemPedido>):
    RecyclerView.Adapter<AdapterPedidoUsuario.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterPedidoUsuario.ViewHolder {
        return AdapterPedidoUsuario.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itempedidousuario,parent,false)
        )
    }

    override fun onBindViewHolder(holder: AdapterPedidoUsuario.ViewHolder, position: Int) {
        val item = items[position]

        holder.idPedido.text = item.idPedido
        holder.fechaPedido.text = item.fechaPedido
        holder.pagoPedido.text = item.tipoPagoPedido
        holder.estadoEntrega.text = item.estadoEntregaPedido


    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val idPedido: TextView = view.findViewById(R.id.idPedido)
        val fechaPedido: TextView = view.findViewById(R.id.fechaPedido)
        val pagoPedido: TextView = view.findViewById(R.id.pagoPedido)
        val estadoEntrega: TextView = view.findViewById(R.id.estadoEntrega)


    }

}