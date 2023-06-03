package com.example.pedidosapp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pedidosapp.databinding.FragmentHomeBinding
import com.example.pedidosapp.databinding.FragmentPedidosBinding

class PedidosFragment : Fragment() {

    private var _binding : FragmentPedidosBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentPedidosBinding.inflate(inflater, container, false)

        return binding.root

    }

}