package com.example.pedidosapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RemoteViews.RemoteCollectionItems
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapterproductos(private var items: List<ItemProducto>):
RecyclerView.Adapter<Adapterproductos.ViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            Adapterproductos.ViewHolder {
            return Adapterproductos.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_producto,parent,false)
       )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items[position]

        holder.nombrem.text = item.Nombre
        holder.tipom.text = item.Tipo
        holder.preciom.text = item.Precio.toString()
        holder.monedam.text = item.Moneda
        Glide.with(holder.itemView.context).load(item.Img).circleCrop().into(holder.fotom)

        holder.botonPromocionm.setOnClickListener {
            val activity = it.context as AppCompatActivity
            Toast.makeText(activity,"hello, wey ${item.Nombre} ${item.Tipo} ${item.Precio} ${item.Moneda}", Toast.LENGTH_LONG).show()
            print("hello, wey ${item.Nombre} ${item.Tipo} ${item.Precio} ${item.Moneda}")
        }


    }

    override fun getItemCount(): Int {
        return items.size
    }
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nombrem: TextView = view.findViewById(R.id.nombreProducto)
        val tipom: TextView = view.findViewById(R.id.tipoProducto)
        val preciom: TextView = view.findViewById(R.id.precioProducto)
        val monedam: TextView = view.findViewById(R.id.monedaProducto)
        val fotom: ImageView = view.findViewById(R.id.fotoProducto)
        val botonPromocionm: Button = view.findViewById(R.id.botonPromociones)
    }

}