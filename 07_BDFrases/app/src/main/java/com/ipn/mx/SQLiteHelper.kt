package com.ipn.mx

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper (context: Context) : SQLiteOpenHelper(context, "FrasesChuck02.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?){
        val sql = "create table Frases(idFrase integer primary key autoincrement "+
        ", frase text, autor text)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("drop table if exists Frases")
        onCreate(db)
    }
    fun create (frase : Frase) : Boolean {
        val db = writableDatabase

        val contentValuses = ContentValues()
        contentValuses.put("frase", frase.frase)
        contentValuses.put("autor",frase.autor)
        val resultado : Long = db.insert("Frases", null, contentValuses)
        return resultado != -1 .toLong()
    }

    fun readAll () : Cursor{
        val db = writableDatabase
        val cursor = db.rawQuery("select * from Frases", null)
        return cursor
    }
}
//vaildar inserta si es blanco/ textutils