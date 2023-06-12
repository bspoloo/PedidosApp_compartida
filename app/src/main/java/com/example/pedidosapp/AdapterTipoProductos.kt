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

class AdapterTipoProductos(private var items: MutableList<ItemProduct>):
    RecyclerView.Adapter<AdapterTipoProductos.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTipoProductos.ViewHolder {
        return AdapterTipoProductos.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itemtipoproducto,parent,false)
        )
    }

    override fun onBindViewHolder(holder: AdapterTipoProductos.ViewHolder, position: Int) {
        val item = items[position]

        holder.nomP.text = item.nomProduct
        holder.desP.text = item.descProduct
        holder.tipP.text = item.tipProduct
        holder.marcP.text = item.marcProduct
        holder.uniP.text = item.uniProduct
        holder.preP.text = item.preProduct.toString()

        Glide.with(holder.itemView.context).load(item.imgProduct).circleCrop().into(holder.fotP)

        holder.botnPP.setOnClickListener{
//            val activity = it.context //as AppCompatActivity
//            Toast.makeText(activity,"ollo, soy ${item.nomProduct} ${item.tipProduct}", Toast.LENGTH_LONG).show()
//            println("ollo, soy ${item.nomProduct} ${item.tipProduct}")

            holder.carViewP.visibility = View.VISIBLE
        }
        holder.cerrarP.setOnClickListener{

            holder.carViewP.visibility = View.GONE
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nomP: TextView = view.findViewById(R.id.nombreProducto)
        val desP: TextView = view.findViewById(R.id.descripcionProducto)
        val tipP: TextView = view.findViewById(R.id.tipoProducto)
        val marcP: TextView = view.findViewById(R.id.marcaProducto)
        val uniP: TextView = view.findViewById(R.id.unidadProducto)
        val preP: TextView = view.findViewById(R.id.precioProducto)

        val fotP: ImageView = view.findViewById(R.id.fotoProducto)
        val botnPP: Button = view.findViewById(R.id.botonPedido)


        val carViewP : CardView = view.findViewById(R.id.cardViewHacerPedido)
        val cerrarP : ImageButton = view.findViewById(R.id.buttonCerrarP)
    }

}