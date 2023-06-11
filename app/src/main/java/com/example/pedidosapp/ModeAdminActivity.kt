package com.example.pedidosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pedidosapp.databinding.ActivityModeAdminBinding

class ModeAdminActivity : AppCompatActivity() {

    private lateinit var binding : ActivityModeAdminBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModeAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.logginAdmin.setOnClickListener {

            val i = Intent(this, AdminActivity::class.java)
            startActivity(i)
        }

    }
}