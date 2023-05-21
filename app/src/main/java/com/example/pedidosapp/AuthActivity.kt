package com.example.pedidosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.pedidosapp.databinding.ActivityAuthBinding
import com.example.pedidosapp.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.net.CacheRequest
import android.widget.Button

class AuthActivity : AppCompatActivity() {

    private lateinit var mAuth : FirebaseAuth
    private val Google_SIGN_IN = 100
    private lateinit var binding : ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
    //inicializar
        mAuth = FirebaseAuth.getInstance()
        boton()

        val btnGoAdmin = findViewById<Button>(R.id.logginadmin)
       btnGoAdmin.setOnClickListener {
           goToAdmin()
       }
    }
    private fun goToAdmin(){
        //pasamos de este activity al acitity main
        val i = Intent(this, AdminActivity::class.java )
        startActivity(i)
    }


    private fun boton()
    {
        binding.loggingoogle.setOnClickListener{

            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
            val googleClient = GoogleSignIn.getClient(this,googleConf)
            val signIntent = googleClient.signInIntent

            startActivityForResult(signIntent, Google_SIGN_IN)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == Google_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try{
                val account = task.getResult(ApiException::class.java)
                if(account != null){
                    Log.d("Tag","firebasegoogleid $account.id")
                    firebaseAuthWithGoogle(account.idToken!!)
                }
                else{
                    Toast.makeText(this,"correo no existe", Toast.LENGTH_LONG).show()

                }
            }
            catch (e:ApiException){
                Log.w("Tag","google sign in failed $e")
            }

        }

    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mAuth.signInWithCredential(credential)
            .addOnCompleteListener(this){
                task -> if(task.isSuccessful){
                    Log.d("Tag","signInWithCredential:success")
                    val user = mAuth.currentUser?.email.toString()
                    login(user)
                }
                else{
                    Log.w("Tag","signInCredential:failure", task.exception)
                    Toast.makeText(this, "no se pudo logear xd", Toast.LENGTH_LONG).show()
                }
            }


    }
}