package com.example.Tarea_Operaciones

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val lblDatos = findViewById<TextView>(R.id.lblBienvenida)
        val sharedPreferences = getSharedPreferences("MISDATOS",
            Context.MODE_PRIVATE)
        val nombreUusario = sharedPreferences.getString("nombreUsuario", "").toString()

        lblDatos.text = "Bienvenido " + nombreUusario

        val btnPromedio = findViewById<Button>(R.id.btnPromedio)
        val btnDesvEstandar = findViewById<Button>(R.id.btnDesvEstandar)
        val btnFactorial = findViewById<Button>(R.id.btnFactorial)

        btnFactorial.setOnClickListener{
            val intent = Intent(this@Welcome, Factorial::class.java)
            startActivity(intent)
        }

        btnPromedio.setOnClickListener{
            val intent = Intent(this@Welcome, Promedio::class.java)
            startActivity(intent)
        }

        btnDesvEstandar.setOnClickListener{
            val intent = Intent(this@Welcome, DesvEstandar::class.java)
            startActivity(intent)
        }
    }
}