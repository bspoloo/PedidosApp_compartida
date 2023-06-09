package com.example.pedidosapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.google.firebase.analytics.FirebaseAnalytics
import com.example.pedidosapp.databinding.FragmentPerfilBinding
import com.google.firebase.auth.FirebaseAuth



    //get() {}

class perfilFragment : Fragment() {

    private var _binding : FragmentPerfilBinding? = null
    //private lateinit var binding_: FragmentPerfilBinding
    //private val viewModel: AdminActivity by activityViewModels()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?


    ): View?
        {
            _binding = FragmentPerfilBinding.inflate(inflater, container, false)

            binding.buttonsesion.setOnClickListener{
                context?.logout()

            }
            val user = FirebaseAuth.getInstance().currentUser       //para obtener el usuario actual
            val correoElectronico = user?.email                     //para obtener el email
            binding.PerfilNombre.text=correoElectronico
            binding.EmailPerfil.text=correoElectronico
            var pedidosfragment = PedidosFragment()
            binding.CuentaPedidos.setOnClickListener {

            }



            return binding.root

    }


}
