package com.example.admirest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Ventas : AppCompatActivity() {

    var editTarjeta:EditText?=null
    var editEfectivo:EditText?=null
    var editFecha: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventas)

        editTarjeta = findViewById(R.id.editTarjeta)
        editEfectivo = findViewById(R.id.editEfectivo)
         editFecha= findViewById(R.id.editFecha)

        var btnAgregar: Button = findViewById(R.id.btnAgregar)


       // sumaDeTodo()

        btnAgregar.setOnClickListener {
        insertar()
        }

    }

//INSERTA VALOR EN LA BASE DE DATOS DE LA VENTA
    fun insertar(){
        //creamos una coneccion
        var con = SQLite(this, "restaurante", null,1)

        //creamos la base de datos
        var baseDatos = con.writableDatabase

        //campos :  son de tipo string pero luego en la base de datos se cambian

        var fecha = editFecha?.text.toString()
        var tarjeta = editTarjeta?.text.toString()
        var efectivo = editEfectivo?.text.toString()

        //comprobamos si se ingresan
        if(tarjeta.isEmpty()== false && efectivo.isEmpty() == false){
            var registro = ContentValues() //ira ingresando los valores
            var suma: Float = tarjeta.toFloat()+ efectivo.toFloat()
            var total = "%.3f".format(suma)

            registro.put("fecha", fecha)
            registro.put("tarjeta", tarjeta)
            registro.put("efectivo", efectivo)
            registro.put("total",total)

            baseDatos.insert("ventas",null,registro) //el null indica que no quiero que ninguna este null
            editFecha?.setText("")
            editTarjeta?.setText("")
            editEfectivo?.setText("")
            Toast.makeText(this, "se ha registrado los datos de la venta.", Toast.LENGTH_LONG).show()//muestra un mensaje
        }else{
            Toast.makeText(this, "Debe ingresar ambos datos", Toast.LENGTH_LONG).show()
        }
        baseDatos.close()
       // sumaDeTodo()

    }

    /*
    fun sumaDeTodo() {
        var con = SQLite(this, "restaurante", null, 1)
        var baseDatos = con.writableDatabase

        var fila = baseDatos.rawQuery("select sum(total) from ventas",null)
        //consulta que suma todos los datos del campo total

        if (fila.moveToFirst() == true) {
            vistaTotal?.setText(fila.getString(0))
            baseDatos.close()
        } else {
            vistaTotal?.setText("0")
        }
    }
*/




}