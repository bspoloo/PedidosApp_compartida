package com.example.pedidosapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pedidosapp.databinding.FragmentLacteosBinding
import com.example.pedidosapp.databinding.FragmentPanaderiaBinding

class PanaderiaFragment : Fragment() {

    private var _binding : FragmentPanaderiaBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentPanaderiaBinding.inflate(inflater, container, false)

        //boton para volver atras.
        binding.buttonBack.setOnClickListener {

            val fragment = HomeFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.nav_frameLayout, fragment)?.commit()
        }
        //boton para volver atras.

        return binding.root
    }

}