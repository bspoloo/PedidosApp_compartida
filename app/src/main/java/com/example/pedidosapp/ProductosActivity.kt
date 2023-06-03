package com.example.pedidosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityProductosBinding
import com.google.firebase.firestore.FirebaseFirestore
import java.util.ArrayList

class ProductosActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle


    private lateinit var binding : ActivityProductosBinding
    private lateinit var adapterusu : Adapterusuarios



    val db = FirebaseFirestore.getInstance()
    private lateinit var adapterproduct : AdapterproductosProm
    private lateinit var producList : ArrayList<ItemProduct>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //para el boton "cerrar sesion xd"
        // binding.logoutgoogle.setOnClickListener{logout()


        //verrecycler()
        llamarrecyclerview()

    }

    private fun llamarrecyclerview() {

        producList = ArrayList()
        adapterproduct = AdapterproductosProm(producList)
        db.collection("Productos")
            .whereEqualTo("Tipo del producto", "Caliente")
            .get()
            .addOnSuccessListener { documets ->
                for(document in documets){
                    val wallItem = document.toObject(ItemProduct::class.java)
                    wallItem.idProduct = document.id
                    wallItem.nomProduct = document["Nombre del producto"].toString()
                    wallItem.tipProduct = document["Tipo del producto"].toString()
                    wallItem.preProduct = document["Precio del producto"].toString().toInt()
                    wallItem.nitProduct = document["Codigo del producto"].toString()
                    wallItem.imgProduct = document["Imagen del producto"].toString()

                    binding.recyclerssProduct.adapter = adapterproduct
                    binding.recyclerssProduct.layoutManager = LinearLayoutManager(this)
                    producList.add(wallItem)
                }
            }

    }



    private fun goToMenu(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
    private fun verrecycler() {
        adapterusu= Adapterusuarios(cargarlista())
        binding.recyclerssProduct.adapter = adapterusu
        binding.recyclerssProduct.layoutManager = LinearLayoutManager(this)
    }

    private fun cargarlista(): MutableList<ItemUsu> {
        val lista = mutableListOf<ItemUsu>()


        lista.add(ItemUsu("Hola wapo xd","Image","https://cdn.discordapp.com/attachments/983473640387518506/1108044449805766676/SPOILER_Screenshot_20230216-171705_Facebook.jpg"))
        lista.add(ItemUsu("Cursed","Image","https://cdn.discordapp.com/attachments/983473640387518506/1108044449805766676/SPOILER_Screenshot_20230216-171705_Facebook.jpg"))
        lista.add(ItemUsu("Cursed","Image","https://cdn.discordapp.com/attachments/983473640387518506/1108044449805766676/SPOILER_Screenshot_20230216-171705_Facebook.jpg"))
        return lista

    }
    private fun replaceFragment(fragment: Fragment, title: String )
    {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()

        drawerLayout.closeDrawers()

        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}