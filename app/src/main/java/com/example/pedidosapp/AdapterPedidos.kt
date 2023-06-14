package com.example.pedidosapp

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class AdapterPedidos(private var items: MutableList<ItemPedido>):
    RecyclerView.Adapter<AdapterPedidos.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterPedidos.ViewHolder {
        return AdapterPedidos.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itempedido,parent,false)
        )
    }

    override fun onBindViewHolder(holder: AdapterPedidos.ViewHolder, position: Int) {
        val item = items[position]

        holder.idPedido.text = item.idPedido
        holder.nombreProductoPedido.text = item.nomProPedido
        holder.tipoProductoPedido.text = item.tipPedido
        holder.marcaProductoPedido.text = item.marcPedido
        holder.unidadProductoPedido.text = item.uniPedido
        holder.ubicacionPedido.text = item.ubiPedido
        holder.nombreDestinatarioPedido.text = item.nomDesPedido
        holder.precioProductoPedido.text = item.prePedido.toString()
        holder.cantidadPedido.text = item.cantPedido.toString()
        holder.totalPagoPedido.text = item.totalPagoPedido
        holder.emailDestinatarioPedido.text = item.EmailDestPedido
        holder.telfDestinatarioPedido.text = item.numTelfPedido.toString()

        holder.fechaPedido.text = item.fechaPedido
        holder.pagoPedido.text = item.tipoPagoPedido
        holder.estadoEntrega.text = item.estadoEntregaPedido


        holder.botonCambiarEstado.setOnClickListener {

            holder.cardViewCambiarEstado.visibility = View.VISIBLE
        }
        holder.buttonCerrarCE.setOnClickListener {

            holder.cardViewCambiarEstado.visibility = View.GONE
        }


//
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val idPedido: TextView = view.findViewById(R.id.idPedido)
        val nombreProductoPedido: TextView = view.findViewById(R.id.nombreProductoPedido)
        val tipoProductoPedido: TextView = view.findViewById(R.id.tipoProductoPedido)
        val marcaProductoPedido: TextView = view.findViewById(R.id.marcaProductoPedido)
        val unidadProductoPedido: TextView = view.findViewById(R.id.unidadProductoPedido)
        val ubicacionPedido: TextView = view.findViewById(R.id.ubicacionPedido)
        val nombreDestinatarioPedido: TextView = view.findViewById(R.id.nombreDestinatarioPedido)
        val precioProductoPedido: TextView = view.findViewById(R.id.precioProductoPedido)
        val cantidadPedido: TextView = view.findViewById(R.id.cantidadPedido)
        val totalPagoPedido: TextView = view.findViewById(R.id.totalPagoPedido)
        val emailDestinatarioPedido: TextView = view.findViewById(R.id.emailDestinatarioPedido)
        val telfDestinatarioPedido: TextView = view.findViewById(R.id.telfDestinatarioPedido)

        val fechaPedido: TextView = view.findViewById(R.id.fechaPedido)
        val pagoPedido: TextView = view.findViewById(R.id.pagoPedido)
        val estadoEntrega: TextView = view.findViewById(R.id.estadoEntrega)

        val botonCambiarEstado: Button = view.findViewById(R.id.botonCambiarEstado)
        val buttonEntregado: Button = view.findViewById(R.id.buttonEntregado)
        val buttonEspera: Button = view.findViewById(R.id.buttonEspera)
        val cardViewCambiarEstado: CardView = view.findViewById(R.id.cardViewCambiarEstado)
        val buttonCerrarCE: ImageButton = view.findViewById(R.id.buttonCerrarCE)



    }

}