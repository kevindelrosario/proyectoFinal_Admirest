package com.example.admirest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.admirest.R




class Estadisticas : AppCompatActivity() {
    var txtVentas :TextView? = null
    var txtPedidos :TextView? = null
    var txtNominas :TextView? = null
    var txtSegSocial :TextView? = null
    var txtAlquiler :TextView? = null
    var txtEstadisticas : TextView? =null
    var sumaTotal:Float = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadisticas)

        txtVentas = findViewById(R.id.txtVentas)
        txtEstadisticas = findViewById(R.id.txtEstadistica)
        txtAlquiler = findViewById(R.id.txtAlquiler)
        txtNominas= findViewById(R.id.txtNominas)
        txtSegSocial = findViewById(R.id.txtSegSocial)

        //MUESTRA LOS DATOS
        TotalVentas()

        txtEstadisticas?.setText("Total facturas: \n" +sumaTotal)
    }


    fun TotalVentas() {
        var con = SQLite(this, "restaurante", null, 1)
        var baseDatos = con.writableDatabase

        var fila = baseDatos.rawQuery("select sum(total) from ventas",null)
        var fila2 = baseDatos.rawQuery("select sum(gastos) from alquiler",null)
        //consulta que suma todos los datos del campo total

        if (fila.moveToFirst() == true) {
            txtVentas?.setText("Ventas:\n"+ fila.getString(0))

            sumaTotal += fila.getString(0).toFloat()
        }
        else {
            txtVentas?.setText("0")
        }
         if(fila2.moveToFirst() == true){
            txtAlquiler?.setText("Alquiler:\n"+ fila2.getString(0))
            sumaTotal += fila2.getString(0).toFloat()


        }
         else {
            txtAlquiler?.setText("0")
        }



    }

}