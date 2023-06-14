package com.example.pedidosapp

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.os.strictmode.CleartextNetworkViolation
import android.text.Editable
import android.util.Log
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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.type.DateTime
import java.math.BigDecimal

class AdapterTipoProductos(private var items: MutableList<ItemProduct>):
    RecyclerView.Adapter<AdapterTipoProductos.ViewHolder>(){

    val db = FirebaseFirestore.getInstance()
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
            holder.carViewEscg.visibility = View.VISIBLE

        }

        //para los botones de Delivery y Recoger
        holder.buttonDely.setOnClickListener {

            holder.carViewP.visibility = View.VISIBLE
            holder.carViewEscg.visibility = View.GONE
            //para cargar esos valores al carview del Delivery
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

            var lugPedido:String = ""
            holder.lugPed.setText(lugPedido)
            holder.lugPed.setEnabled(true)



            //para cargar esos valores al carview del Delivery
        }



        holder.buttonRecog.setOnClickListener {

            holder.carViewP.visibility = View.VISIBLE
            holder.carViewEscg.visibility = View.GONE

            //para cargar esos valores al carview del Delivery
            var nomPedido: String = item.nomProduct
            holder.nomDaP.setText(nomPedido)

            var descPedido: String = item.descProduct
            holder.descDaP.setText(descPedido)

            var tipPedido: String = item.tipProduct
            holder.tipDaP.setText(tipPedido)

            var marcPedido: String = item.marcProduct
            holder.marcDaP.setText(marcPedido)

            var uniPedido: String = item.uniProduct
            holder.uniDaP.setText(uniPedido)

            var lugPedido:String = "Lugar: Jaime Mendoza #825"
            holder.lugPed.setText(lugPedido)
            holder.lugPed.setEnabled(false)

            var prePedido: Float = item.preProduct
            holder.preDaP.setText(prePedido.toString())


        }
            //para cargar esos valores al carview del Delivery
        //para los botones de Delivery y Recoger



        // para el boton de cotizar
        holder.botnCotiz.setOnClickListener {


            val activity = it.context
            if(holder.cantPed.text.toString().isBlank()){
                Toast.makeText(activity,"Por favor introduzca una cantidad", Toast.LENGTH_LONG).show()
            }
            else{


                val cantidadP = Integer.parseInt(holder.cantPed.text.toString())
                val precioP = item.preProduct
                val cotizar = cantidadP * precioP

                var cotPedido: String = cotizar.toString() + " Bs"
                holder.EditCoti.setText(cotPedido)

            }

        }


        holder.cerrarEP.setOnClickListener {

            holder.carViewEscg.visibility = View.GONE

        }
        holder.cerrarP.setOnClickListener {

            holder.carViewP.visibility = View.GONE
            holder.carViewEscg.visibility = View.GONE

        }

        holder.buttonPagar.setOnClickListener {

            val activity = it.context
            val user = FirebaseAuth.getInstance().currentUser       //para obtener el usuario actual
            val correoElectronico = user?.email                     //para obtener el email

            if(holder.cantPed.text.toString().isBlank()){
                Toast.makeText(activity,"Por favor introduzaca una cantidad", Toast.LENGTH_LONG).show()
            }
            else{


                val cantidadP = Integer.parseInt(holder.cantPed.text.toString())
                val precioP = item.preProduct
                val cotizar = cantidadP * precioP

                var cotPedido: String = cotizar.toString() + " Bs"
                holder.EditCoti.setText(cotPedido)

            }

            if( holder.DatoUbicacionPedido.text.toString().isBlank()
                or holder.DatoDestinatarioPedido.text.toString().isBlank()
                or holder.cantPed.text.toString().isBlank()) {
                Toast.makeText(activity, "Por favor rellene los campos", Toast.LENGTH_LONG).show()
            }

            else{

                val Pedido = hashMapOf(

                    "Nombre del Producto" to holder.nomDaP.text.toString(),
                    "Tipo del Prodducto" to holder.tipDaP.text.toString(),
                    "Marca del Producto" to holder.marcDaP.text.toString(),
                    "Unidad del Producto" to holder.uniDaP.text.toString(),
                    "Ubicacion" to holder.DatoUbicacionPedido.text.toString(),
                    "Nombre del destinatario" to holder.DatoDestinatarioPedido.text.toString(),
                    "Precio" to holder.preDaP.text.toString().toFloat(),
                    "Cantidad" to holder.cantPed.text.toString().toInt(),
                    "Total a pagar" to holder.cantPed.text.toString(),
                    "Total a pagar" to holder.cantPed.text.toString(),
                    "Email del destinatario" to correoElectronico,


                    "Numero de telefono" to holder.numPed.text.toString().toInt(),
                    "Fecha del pedido" to holder.fechaped.toString(),

                )
                db.collection("Pedidos")
                    .add(Pedido)
                    .addOnSuccessListener {  documentReference ->
                        Toast.makeText(activity, "Su pedido fue realizado exitosamente", Toast.LENGTH_LONG).show()
                        println("agregado correctamente xd")

                    }
                    .addOnFailureListener {e-> Log.w("Tag","Error $e")}

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
        val carViewEscg : CardView = view.findViewById(R.id.cardViewEscogerPedido)
        val buttonDely : Button = view.findViewById(R.id.buttonDelibery)
        val buttonRecog : Button = view.findViewById(R.id.buttonRecoger)
        val cerrarP : ImageButton = view.findViewById(R.id.buttonCerrarP)
        val cerrarEP : ImageButton = view.findViewById(R.id.buttonCerrarEP)

        val botnCotiz : Button = view.findViewById(R.id.buttonCotizar)
        val cantPed : EditText = view.findViewById(R.id.DatoCantidadPedido)
        val lugPed : EditText = view.findViewById(R.id.DatoUbicacionPedido)

        val numPed : EditText = view.findViewById(R.id.DatoNumero)
        val fechaped: DateTime = DateTime.getDefaultInstance()


        //para el cardview de pedidos
        val nomDaP : EditText = view.findViewById(R.id.DatoNombrePedido)
        val descDaP : EditText = view.findViewById(R.id.DatoDescripcionPedido)
        val tipDaP : EditText = view.findViewById(R.id.DatoTipoPedido)
        val marcDaP : EditText = view.findViewById(R.id.DatoMarcaPedido)
        val uniDaP : EditText = view.findViewById(R.id.DatoUnidadPedido)
        val preDaP : EditText = view.findViewById(R.id.DatoPrecioPedido)
        val EditCoti : EditText = view.findViewById(R.id.EditCotizar)
        val DatoUbicacionPedido : EditText = view.findViewById(R.id.DatoUbicacionPedido)
        val DatoDestinatarioPedido : EditText = view.findViewById(R.id.DatoDestinatarioPedido)

        val buttonPagar : Button = view.findViewById(R.id.buttonPagar)


    }




}


