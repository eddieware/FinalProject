package com.example.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.apiadapter.BeerAdapter
import com.example.apiadapter.Results
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.beer_activity_list.*

class BeerActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.beer_activity_list)
        rcvList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        val intent = this.intent
        var cerveza = intent.getStringExtra("RAZA").toLowerCase()
        txtHeader.text = "Resultados cerveza: "+cerveza
        RequestVolley("https://api.punkapi.com/v2/beers?beer_name="+cerveza)

    }

    private fun RequestVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(Request.Method.GET, url, Response.Listener<String> {
                response ->
            try {
                val myType = object : TypeToken<ArrayList<Results>>() {}.type
                val gson = Gson()
                val listDogs = gson.fromJson<ArrayList<Results>>(response,myType)
                val adaptador = BeerAdapter(listDogs)
                println(listDogs.get(0).image_url)
                println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!")
                rcvList.adapter = adaptador
            } catch (e: Exception) {
                e.printStackTrace()

            }
        }, Response.ErrorListener {  })
        queue.add(request)
    }
}