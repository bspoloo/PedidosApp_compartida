package com.example.pedidosapp

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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
import java.math.BigDecimal

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


            //para cargar esos valores al carview del pedido
            var nomPedido:String = item.nomProduct
            holder.nomDaP.setText(nomPedido)

            var descPedido:String = item.descProduct
            holder.descDaP.setText(descPedido)

            var tipPedido:String = item.tipProduct
            holder.tipDaP.setText(tipPedido)

            var marcPedido:String = item.marcProduct
            holder.marcDaP.setText(marcPedido)

            var uniPedido:String = item.uniProduct
            holder.uniDaP.setText(uniPedido)

            var prePedido:Float = item.preProduct
            holder.preDaP.setText(prePedido.toString())
            //para cargar esos valores al carview del pedido

        }
        holder.cerrarP.setOnClickListener{

            holder.carViewP.visibility = View.GONE
        }

        // para el boton de cotizar
        holder.botnCotiz.setOnClickListener {

            val activity = it.context
            if(holder.cantPed.text.toString().isBlank()){
                Toast.makeText(activity,"Por favor introduzaca una cantidad", Toast.LENGTH_LONG).show()
            }
            else{

                val cantidadP = Integer.parseInt(holder.cantPed.text.toString())
                val precioP = item.preProduct
                val cotizar = cantidadP * precioP

                holder.textCotiz.text = cotizar.toString() + " Bs"
            }

        }



        // para el boton de cotizar

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

        val botnCotiz : Button = view.findViewById(R.id.buttonCotizar)
        val textCotiz : TextView = view.findViewById(R.id.textCotizar)
        val cantPed : EditText = view.findViewById(R.id.DatoCantidadPedido)

        //para el cardview de pedidos
        val nomDaP : EditText = view.findViewById(R.id.DatoNombrePedido)
        val descDaP : EditText = view.findViewById(R.id.DatoDescripcionPedido)
        val tipDaP : EditText = view.findViewById(R.id.DatoTipoPedido)
        val marcDaP : EditText = view.findViewById(R.id.DatoMarcaPedido)
        val uniDaP : EditText = view.findViewById(R.id.DatoUnidadPedido)
        val preDaP : EditText = view.findViewById(R.id.DatoPrecioPedido)


    }

}


