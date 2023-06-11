package com.example.pedidosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pedidosapp.databinding.ActivityModeAdminBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ModeAdminActivity : AppCompatActivity() {

    private lateinit var binding : ActivityModeAdminBinding

    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var authStateListener : FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModeAdminBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = Firebase.auth

        binding.logginAdmin.setOnClickListener {

            singIn(binding.DatoAdminCorreo.text.toString(), binding.DatoAdminPassword.text.toString())

        }


    }

    private fun singIn(email: String, password : String){


        if(binding.DatoAdminCorreo.text.toString().isBlank() or binding.DatoAdminPassword.text.toString().isBlank()){

            Toast.makeText(baseContext,"Por favor ingrese los datos", Toast.LENGTH_LONG).show()
        }
        else{
            firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this) {task ->
                    if(task.isSuccessful){
//                        val user = firebaseAuth.currentUser
//                        Toast.makeText(baseContext,user?.uid.toString(), Toast.LENGTH_LONG).show()
                        val i = Intent(this, AdminActivity::class.java)
                        startActivity(i)

                    }
                    else{
                        Toast.makeText(baseContext,"Correo o contraseña incorrecta", Toast.LENGTH_LONG).show()
                    }
                }
        }


    }
}