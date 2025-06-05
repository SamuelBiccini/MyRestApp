package com.example.myrestapp_samuelbiccini

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.security.MessageDigest

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val inputN = findViewById<EditText>(R.id.editTextNome)
        val inputP = findViewById<EditText>(R.id.editTextTextPassword)
        val login = findViewById<Button>(R.id.login)

        login.setOnClickListener {
            controlloLogin(inputN.text.toString(), sha256(inputP.text.toString()))
        }
    }

    private fun controlloLogin(nome: String, password: String){
        //Login
        val nomeUtente = "Biccini"
        val passwordUtente = "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4" //1234

        //Se gli inpjut sono corretti
        if(nomeUtente == nome && passwordUtente == password){
            lanciaIntent()
        }
        else{
            val mioToast = Toast.makeText(this, "Accesso negato!", Toast.LENGTH_LONG)
            mioToast.show()
        }
    }

    private fun sha256(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    private fun lanciaIntent(){
        val mioIntent = Intent(this, MenuActivity::class.java)
        startActivity(mioIntent)
    }
}