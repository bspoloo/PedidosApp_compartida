package com.example.pedidosapp

import android.content.ClipData.Item
import android.content.Intent
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.text.TextUtils.replace
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pedidosapp.databinding.ActivityAuthBinding
import com.example.pedidosapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapterusu : Adapterusuarios

    //Navegacion Inferior

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)



        //Navegacion Inferior
        //var adminfragment = AdminActivity()
        var homefragment = HomeFragment()
        var pedidosfragment = PedidosFragment()
        var perfilfragment = perfilFragment()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {

                    when(it.itemId){
                        R.id.nav_admin -> {
                            goToAdmin()
                            true
                        }
                        R.id.Hogar -> {
                            setCurrentFragment(homefragment)
                            true
                        }
                        R.id.pedidos -> {
                            setCurrentFragment(pedidosfragment)
                            true
                        }
                        R.id.logout -> {
                            setCurrentFragment(perfilfragment)
                            //logout()

                            true

                        }
                        else -> false

                    }
        }
        //Navegacion Inferior



    //agregamos un analitycs para prueba rapida xd
        val analitycs = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","comenzando app")

        analitycs.logEvent("MainActivity", bundle)
    //agregamos un analitycs para prueba rapida xd

        //verrecycler()
    }

    //Navegacion Inferior
    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.FragmentContainerView, fragment)
            commit()
        }
    }
    //Navegacion Inferior


    private fun goToAdmin(){
        val i = Intent(this, AdminActivity::class.java)
        startActivity(i)
    }


    // private fun verrecycler() {
    //    adapterusu= Adapterusuarios(cargarlista())
    //    binding.recyclerss.adapter = adapterusu
    //    binding.recyclerss.layoutManager = LinearLayoutManager(this)
   // }

    private fun cargarlista(): MutableList<ItemUsu> {
        val lista = mutableListOf<ItemUsu>()

        lista.add(ItemUsu("Cursed","Image","https://cdn.discordapp.com/attachments/983473640387518506/1108044449805766676/SPOILER_Screenshot_20230216-171705_Facebook.jpg"))
        lista.add(ItemUsu("Cursed","Image","https://cdn.discordapp.com/attachments/983473640387518506/1108044449805766676/SPOILER_Screenshot_20230216-171705_Facebook.jpg"))
        return lista

    }
}