package com.example.pedidosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityAdminBinding
import com.google.firebase.firestore.FirebaseFirestore

class AdminActivity : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    private lateinit var adapterproduct : Adapterproductos
    private lateinit var binding : ActivityAdminBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val guardarDatos = findViewById<Button>(R.id.buttonGuardar) as Button
        val borrarProducto = findViewById<Button>(R.id.buttonEliminar) as Button


        guardarDatos.setOnClickListener(){
            agregarDatos()

        }
        borrarProducto.setOnClickListener(){
            eliminarProducto()
        }



        verrecycler()
    }



    private fun agregarDatos() {
        if(binding.DatoTipo.text.toString().isBlank() or binding.DatoPrecio.text.toString().isBlank() or binding.DatoNitProducto.text.toString().isBlank()) {
            Toast.makeText(this, "Por favor rellene los campos", Toast.LENGTH_LONG).show()
        }

        else{
            val user = hashMapOf(

                "Nombre del producto" to binding.DatoProducto.text.toString(),
                "Tipo del producto" to binding.DatoTipo.text.toString(),
                "Precio del producto" to binding.DatoPrecio.text.toString().toInt()

            )
            db.collection("Productos").document(binding.DatoNitProducto.text.toString())
                .set(user)
                .addOnSuccessListener { Log.d("Tag","se guardo correctamente") }
                .addOnFailureListener {e-> Log.w("Tag","Error $e")}

            binding.DatoProducto.text.clear()
            binding.DatoTipo.text.clear()
            binding.DatoPrecio.text.clear()
            binding.DatoNitProducto.text.clear()

            Toast.makeText(this, "Producto agregado correctamente", Toast.LENGTH_LONG).show()
        }

    }
    private fun eliminarProducto() {

        val datoBuscar =binding.DatoBuscarProducto.text.toString()
        val docRef = db.collection("Productos").document( binding.DatoBuscarProducto.text.toString()).toString()

        if(binding.DatoBuscarProducto.text.toString().isBlank() ) {
            Toast.makeText(this, "No puso el Codigo de producto", Toast.LENGTH_LONG).show()
        }
        else{
            if(docRef == datoBuscar)
            {
                db.collection("Productos").document( binding.DatoBuscarProducto.text.toString())
                    .delete()
                    .addOnSuccessListener { Log.d("Tag","se Elimino correctamente") }
                    .addOnFailureListener {e-> Log.w("Tag","Error al borrar el documento $e")}

                Toast.makeText(this, "Se elimino correctamente $datoBuscar", Toast.LENGTH_LONG).show()
                binding.DatoBuscarProducto.text.clear()
            }
            else{
                Toast.makeText(this, "No existe producto $datoBuscar", Toast.LENGTH_LONG).show()
            }

        }
    }




    private fun verrecycler() {
        adapterproduct= Adapterproductos(cargarlista())
        binding.recyclerssProduct.adapter = adapterproduct
        binding.recyclerssProduct.layoutManager = LinearLayoutManager(this)
    }

    private fun cargarlista(): MutableList<ItemProduct> {
        val lista = mutableListOf<ItemProduct>()

        lista.add(ItemProduct("1","Arroz","Integral",50, "123455","https://somoskudasai.com/wp-content/uploads/2023/04/portada_go-toubun-no-hanayome-170.jpg"))
        lista.add(ItemProduct("1","Arroz","Integral",50, "123456","https://somoskudasai.com/wp-content/uploads/2023/04/portada_go-toubun-no-hanayome-170.jpg"))
        lista.add(ItemProduct("1","Arroz","Integral",50, "123457","https://somoskudasai.com/wp-content/uploads/2023/04/portada_go-toubun-no-hanayome-170.jpg"))
        lista.add(ItemProduct("1","Arroz","Integral",50, "123457","https://somoskudasai.com/wp-content/uploads/2023/04/portada_go-toubun-no-hanayome-170.jpg"))
        lista.add(ItemProduct("1","Arroz","Integral",50, "123457","https://somoskudasai.com/wp-content/uploads/2023/04/portada_go-toubun-no-hanayome-170.jpg"))
        lista.add(ItemProduct("1","Arroz","Integral",50, "123457","https://somoskudasai.com/wp-content/uploads/2023/04/portada_go-toubun-no-hanayome-170.jpg"))

        return lista

    }
}