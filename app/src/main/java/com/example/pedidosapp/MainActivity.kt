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
import com.google.android.material.navigation.NavigationView
import com.google.firebase.analytics.FirebaseAnalytics
class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle


    private lateinit var binding : ActivityMainBinding
    private lateinit var adapterusu : Adapterusuarios

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    //agregamos un analitycs para prueba rapida xd
        val analitycs = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","comenzando app")

        analitycs.logEvent("MainActivity", bundle)



        drawerLayout =findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            it.isChecked = true

            when(it.itemId)
            {
                R.id.nav_admin -> goToAdmin()
                R.id.nav_home -> goToMenu()
                R.id.nav_Carrito -> productos()
                R.id.nav_promociones -> replaceFragment(PromocionesFragment(),it.title.toString())
                R.id.nav_telefono -> replaceFragment(TelefonoFragment(),it.title.toString())
                //R.id.nav_logout -> replaceFragment(logoutFragment(),it.title.toString())
                R.id.nav_logout -> logout()
            }
            true

        }

        //para el boton "cerrar sesion xd"
       // binding.logoutgoogle.setOnClickListener{logout()


        verrecycler()
    }

    private fun goToMenu(){
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }
    private fun productos(){
        val i = Intent(this, ProductosActivity::class.java)
        startActivity(i)
    }
    private fun goToAdmin(){
        val i = Intent(this, AdminActivity::class.java)
        startActivity(i)
    }
     private fun verrecycler() {
        adapterusu= Adapterusuarios(cargarlista())
        binding.recyclerss.adapter = adapterusu
        binding.recyclerss.layoutManager = LinearLayoutManager(this)
    }

    private fun cargarlista(): MutableList<ItemUsu> {
        val lista = mutableListOf<ItemUsu>()


        lista.add(ItemUsu("Cursed","Image","https://cdn.discordapp.com/attachments/983473640387518506/1108044449805766676/SPOILER_Screenshot_20230216-171705_Facebook.jpg"))
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