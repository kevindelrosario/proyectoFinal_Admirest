package com.example.admirest
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**Implementanso
 * import android.database.sqlite.SQLiteOpenHelper
 *  y sus componentes
 *
 */
class SQLite(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
//creamos la tabla desde que se instale la app
        db?.execSQL("create table ventas( fecha text, tarjeta real,efectivo real, total real) ")
        db?.execSQL("create table alquiler( gastos real) ")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}