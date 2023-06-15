package com.example.pedidosapp

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.util.Log
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


class AdapterIntegrantes(private var items: MutableList<ItemIntegrante>):
    RecyclerView.Adapter<AdapterIntegrantes.ViewHolder>(){

    val db = FirebaseFirestore.getInstance()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterIntegrantes.ViewHolder {
        return AdapterIntegrantes.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itemintegrante,parent,false)
        )
    }

    override fun onBindViewHolder(holder: AdapterIntegrantes.ViewHolder, position: Int) {
        val item = items[position]

        holder.nombreIntegrante.text = item.nomIntegrante
        holder.telfIntegrante.text = item.telfIntegrante.toString()
        holder.rolIntegrante.text = item.rolIntegrante

        Glide.with(holder.itemView.context).load(item.urlIntegrante).circleCrop().into(holder.fotoIntegrante)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        val nombreIntegrante: TextView = view.findViewById(R.id.nombreIntegrante)
        val telfIntegrante: TextView = view.findViewById(R.id.telfIntegrante)
        val rolIntegrante: TextView = view.findViewById(R.id.rolIntegrante)

        val fotoIntegrante: ImageView = view.findViewById(R.id.fotoIntegrante)

    }
}