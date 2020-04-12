package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.apiadapter.BeerActivity
import com.example.apiadapter.Network
import kotlinx.android.synthetic.main.beer_activity_main.*

class BeerMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beer_activity_main)


        searchBtn.setOnClickListener {
            if (Network.hayRed(this)) {
                val intLista = Intent(this, BeerActivity::class.java)
                intLista.putExtra("RAZA", edtxtRaza.text.toString())
                startActivity(intLista)
            } else {
                Toast.makeText(this, "No hay red", Toast.LENGTH_LONG).show()
            }
        }
    }
}