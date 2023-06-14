package com.example.pedidosapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

                val activity = it.context
                val builder = AlertDialog.Builder(activity)

                builder.setTitle("Cerrar Sesion")
                builder.setMessage("Estas seguro de cerrar tu sesion?")
                builder.setPositiveButton("si"){ dialogInterface : DialogInterface, i: Int->
                    context?.logout()
                }
                builder.setNegativeButton("no"){ dialogInterface : DialogInterface, i: Int->
                    //no pasa nada xd
                }
                builder.show()


            }

            val user = FirebaseAuth.getInstance().currentUser       //para obtener el usuario actual
            val correoElectronico = user?.email                     //para obtener el email
            binding.PerfilNombre.text=correoElectronico
            binding.EmailPerfil.text=correoElectronico

            binding.IniciarAdmin.setOnClickListener {

                val i = Intent(context, ModeAdminActivity::class.java)
                startActivity(i)
            }

            return binding.root

    }


}
