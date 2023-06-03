package com.example.pedidosapp

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
            val fragment = BebidasFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_frameLayout, fragment)?.commit()
        }
        binding.buttonLicores.setOnClickListener{

            val fragment = LicoresFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_frameLayout, fragment)?.commit()
        }
        binding.buttonPanaderia.setOnClickListener{

            val fragment = PanaderiaFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_frameLayout, fragment)?.commit()
        }
        binding.buttonSnack.setOnClickListener{

            val fragment = SnacksFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_frameLayout, fragment)?.commit()
        }
        binding.buttonLacteos.setOnClickListener{

            val fragment = LacteosFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_frameLayout, fragment)?.commit()
        }
        binding.buttonEnlatados.setOnClickListener{

            val fragment = EnlatadosFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_frameLayout, fragment)?.commit()
        }
        binding.buttonCarnes.setOnClickListener{

            val fragment = CarnesFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_frameLayout, fragment)?.commit()
        }
        binding.buttonCongelados.setOnClickListener{

            val fragment = CongeladosFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_frameLayout, fragment)?.commit()
        }



        return binding.root
    }


}