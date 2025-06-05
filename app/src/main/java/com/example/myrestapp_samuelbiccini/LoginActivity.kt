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
        val passwordUtente = "a883dafc480d466ee04e0d6da986bd78eb1fdd2178d04693723da3a8f95d42f4" //1234

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