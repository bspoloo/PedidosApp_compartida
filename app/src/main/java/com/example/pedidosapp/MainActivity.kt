package com.example.pedidosapp

import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.text.TextUtils.replace
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.pedidosapp.databinding.ActivityAuthBinding
import com.example.pedidosapp.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle

    private lateinit var reciclersss: RecyclerView

    private lateinit var binding : ActivityMainBinding
    private lateinit var adpaterProd : Adapterproductos
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

                R.id.nav_home -> replaceFragment(HomeFragment(),it.title.toString())
                R.id.nav_Carrito -> replaceFragment(CarritoFragment(),it.title.toString())
                R.id.nav_promociones -> replaceFragment(PromocionesFragment(),it.title.toString())
                R.id.nav_telefono -> replaceFragment(TelefonoFragment(),it.title.toString())
                //R.id.nav_logout -> replaceFragment(logoutFragment(),it.title.toString())
                R.id.nav_logout -> logout()
            }
            true




        }

        //para el boton "cerrar sesion xd"
       // binding.logoutgoogle.setOnClickListener{logout()
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