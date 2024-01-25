package com.example.admirest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Alquiler : AppCompatActivity() {


    var editAlquiler:EditText?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alquiler)

        editAlquiler = findViewById(R.id.editAlquiler)
        var btnAgregar: Button = findViewById(R.id.btnAgregarAlquiler)



        btnAgregar.setOnClickListener {
            insertar()
        }

    }

    fun insertar(){
        //creamos una coneccion
        var con = SQLite(this, "restaurante", null,1)
        //creamos la base de datos
        var baseDatos = con.writableDatabase

        //campos :  son de tipo string pero luego en la base de datos se cambian
        var gastos = editAlquiler?.text.toString()

        //comprobamos si se ingresan
        if(gastos.isEmpty() == false){
            var registro = ContentValues() //ira ingresando los valores

            registro.put("gastos", gastos)//nombre que tiene el campo

            baseDatos.insert("alquiler",null,registro) //el null indica que no quiero que ninguna este null
            editAlquiler?.setText("")

            Toast.makeText(this, "se ha registrado los datos del alquiler.", Toast.LENGTH_LONG).show()//muestra un mensaje
        }else{
            Toast.makeText(this, "Verificar que se ha ingresado un precio...", Toast.LENGTH_LONG).show()
        }
        baseDatos.close()


    }



}