package com.example.pedidosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityMainBinding
import com.example.pedidosapp.databinding.ActivityProductosBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.analytics.FirebaseAnalytics

class ProductosActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle


    private lateinit var binding : ActivityProductosBinding
    private lateinit var adapterusu : Adapterusuarios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)



        //para el boton "cerrar sesion xd"
        // binding.logoutgoogle.setOnClickListener{logout()


       // verrecycler()
    }
































    private fun goToMenu(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
    private fun verrecycler() {
        adapterusu= Adapterusuarios(cargarlista())
        binding.recyclerss.adapter = adapterusu
        binding.recyclerss.layoutManager = LinearLayoutManager(this)
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