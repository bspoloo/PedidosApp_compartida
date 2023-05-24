package com.example.pedidosapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapterproductos(private var items: MutableList<ItemProduct>):
    RecyclerView.Adapter<Adapterproductos.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapterproductos.ViewHolder {
        return Adapterproductos.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itemproduct,parent,false)
        )
    }

    override fun onBindViewHolder(holder: Adapterproductos.ViewHolder, position: Int) {
        val item = items[position]

        holder.nomP.text = item.nomProduct
        holder.tipP.text = item.tipProduct
        holder.preP.text = item.preProduct.toString()
        holder.nitP.text = item.nitProduct


        Glide.with(holder.itemView.context).load(item.imgProduct).circleCrop().into(holder.fotP)
        holder.botnPP.setOnClickListener{
            val activity = it.context //as AppCompatActivity
            Toast.makeText(activity,"ollo, soy ${item.nomProduct} ${item.tipProduct}", Toast.LENGTH_LONG).show()
            println("ollo, soy ${item.nomProduct} ${item.tipProduct}")
        }

        holder.botnPE.setOnClickListener{
            items.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nomP: TextView = view.findViewById(R.id.nombreProducto)
        val tipP: TextView = view.findViewById(R.id.tipoProducto)
        val preP: TextView = view.findViewById(R.id.precioProducto)
        val nitP: TextView = view.findViewById(R.id.codigoProducto)
        val fotP: ImageView = view.findViewById(R.id.fotoProducto)
        val botnPP: Button = view.findViewById(R.id.botonPrecioname)
        val botnPE: Button = view.findViewById(R.id.botonEliminame)

    }

}