package com.example.pedidosapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pedidosapp.databinding.FragmentHomeBinding
import com.example.pedidosapp.databinding.FragmentTelefonoBinding

class HomeFragment : Fragment()
{


    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.buttonBebidas.setOnClickListener{

            val i = Intent(context, BebidasActivity::class.java)
            startActivity(i)

        }
        binding.buttonLicores.setOnClickListener{

            val i = Intent(context, LicoresActivity::class.java)
            startActivity(i)
        }
        binding.buttonPanaderia.setOnClickListener{

            val i = Intent(context, PanaderiaActivity::class.java)
            startActivity(i)
        }
        binding.buttonSnack.setOnClickListener{

            val i = Intent(context, SnacksActivity::class.java)
            startActivity(i)
        }
        binding.buttonLacteos.setOnClickListener{

            val i = Intent(context, LacteosActivity::class.java)
            startActivity(i)
        }
        binding.buttonEnlatados.setOnClickListener{

            val i = Intent(context, EnlatadosActivity::class.java)
            startActivity(i)
        }
        binding.buttonCarnes.setOnClickListener{

            val i = Intent(context, CarnesActivity::class.java)
            startActivity(i)
        }
        binding.buttonCongelados.setOnClickListener{

            val i = Intent(context, CongeladosActivity::class.java)
            startActivity(i)
        }

        return binding.root
    }


}