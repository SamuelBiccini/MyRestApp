package com.example.myrestapp_samuelbiccini

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val inputN = findViewById<EditText>(R.id.editTextNome)
        val inputP = findViewById<EditText>(R.id.editTextTextPassword)
        val login = findViewById<Button>(R.id.login)
    }
}