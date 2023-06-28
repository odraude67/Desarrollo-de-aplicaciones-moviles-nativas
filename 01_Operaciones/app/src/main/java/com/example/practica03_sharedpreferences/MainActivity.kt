package com.example.Tarea_Operaciones

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("MISDATOS",
            Context.MODE_PRIVATE)
        val nombreUsuario = sharedPreferences.getString("claveUsuario", "")
        val claveDeUsuario = sharedPreferences.getString("claveDeUsuario", "")

        val btnAceptar = findViewById<Button>(R.id.btnEntrar)
        val txtNombre = findViewById<TextView>(R.id.txtNombre)
        val txtPassword = findViewById<TextView>(R.id.txtPassword)
        val checkBoxRecuerdame = findViewById<TextView>(R.id.checkBoxRecuerdame)

        // Agregar logica para verificar si el checkbox esta marcado
            // Adicional, agregar si los campos de usuario y clave tienen algo escrito

        btnAceptar.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.putString("nombreUsuario", txtNombre.text.toString())
            editor.putString("claveDeUsuario", txtNombre.text.toString())
            editor.apply()

            val intent = Intent(this@MainActivity, Welcome::class.java)
            startActivity(intent)
        }
    }
}