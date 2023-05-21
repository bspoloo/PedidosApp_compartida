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

class Adapterusuarios(private var items: List<ItemUsu>):
    RecyclerView.Adapter<Adapterusuarios.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapterusuarios.ViewHolder {
        return Adapterusuarios.ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.itemusu,parent,false)
        )
    }

    override fun onBindViewHolder(holder: Adapterusuarios.ViewHolder, position: Int) {
        val item = items[position]
        holder.nomm.text = item.Nom
        holder.apm.text = item.Ap
        Glide.with(holder.itemView.context).load(item.Img).circleCrop().into(holder.fotm)
        holder.botnm.setOnClickListener{
            val activity = it.context //as AppCompatActivity
            Toast.makeText(activity,"ollo, soy ${item.Nom} ${item.Ap}", Toast.LENGTH_LONG).show()
            println("ollo, soy ${item.Nom} ${item.Ap}")
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val nomm: TextView = view.findViewById(R.id.Nombre)
        val apm: TextView = view.findViewById(R.id.Apellido)
        val fotm: ImageView = view.findViewById(R.id.lafoto)
        val botnm: Button = view.findViewById(R.id.boton)

    }

}