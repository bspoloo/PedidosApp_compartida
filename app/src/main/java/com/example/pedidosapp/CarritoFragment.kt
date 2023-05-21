package com.example.pedidosapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pedidosapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.analytics.FirebaseAnalytics

class CarritoFragment : Fragment(R.layout.fragment_carrito)
{


    private lateinit var binding : ActivityMainBinding
    private lateinit var adapterusu : Adapterusuarios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       // verrecycler()
    }

    private fun verrecycler() {
        adapterusu= Adapterusuarios(cargarlista())
        binding.recyclerss.adapter = adapterusu
        binding.recyclerss.layoutManager = LinearLayoutManager(context)
    }

    private fun cargarlista(): MutableList<ItemUsu> {
        val lista = mutableListOf<ItemUsu>()


        lista.add(ItemUsu("Cursed","Image","https://cdn.discordapp.com/attachments/983473640387518506/1108044449805766676/SPOILER_Screenshot_20230216-171705_Facebook.jpg"))
        lista.add(ItemUsu("Cursed","Image","https://cdn.discordapp.com/attachments/983473640387518506/1108044449805766676/SPOILER_Screenshot_20230216-171705_Facebook.jpg"))
        lista.add(ItemUsu("Cursed","Image","https://cdn.discordapp.com/attachments/983473640387518506/1108044449805766676/SPOILER_Screenshot_20230216-171705_Facebook.jpg"))

        return lista


    }


}