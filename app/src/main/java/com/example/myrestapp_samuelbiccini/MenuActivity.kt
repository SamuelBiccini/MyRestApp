package com.example.myrestapp_samuelbiccini

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val bottoneSito = findViewById<ImageButton>(R.id.bottoneSito)
        val bottoneSearch = findViewById<ImageButton>(R.id.bottoneSearch)

        bottoneSito.setOnClickListener {
            val mioIntent = Intent(this, NetflixActivity::class.java)
            startActivity(mioIntent)
        }

        bottoneSearch.setOnClickListener {
            val mioIntent = Intent(this, SearchActivity::class.java)
            startActivity(mioIntent)
        }

    }
}