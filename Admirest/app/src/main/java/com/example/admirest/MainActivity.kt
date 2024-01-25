package com.example.admirest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val btnVentas:Button = findViewById(R.id.btnVentas)
        val btnPedidos:Button = findViewById(R.id.btnPedidos)
        val btnAlquiler:Button = findViewById(R.id.btnAlquiler)
        val btnNominas:Button = findViewById(R.id.btnNominas)
        val btnSegSocial:Button = findViewById(R.id.btnSeguridadSocial)
        val btnEstadisticas:Button = findViewById(R.id.btnEstadisticas)



        btnVentas.setOnClickListener {
            val intentDos= Intent(this, Ventas::class.java)
            startActivity(intentDos)
        }
        btnPedidos.setOnClickListener {
            val intentDos= Intent(this, Pedidos ::class.java)
            startActivity(intentDos)
        }
        btnAlquiler.setOnClickListener {
            val intentDos= Intent(this, Alquiler::class.java)
            startActivity(intentDos)
        }
        btnNominas.setOnClickListener {
            val intentDos= Intent(this, Nominas::class.java)
            startActivity(intentDos)
        }
        btnSegSocial.setOnClickListener {
            val intentDos= Intent(this, SegSocial::class.java)
            startActivity(intentDos)
        }
        btnEstadisticas.setOnClickListener {
            var intentDos= Intent(this, Estadisticas::class.java)
            startActivity(intentDos)
        }







    }
}