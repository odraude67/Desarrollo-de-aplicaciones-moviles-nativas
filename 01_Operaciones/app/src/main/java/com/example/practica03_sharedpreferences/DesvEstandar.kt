package com.example.Tarea_Operaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Math.sqrt

class DesvEstandar : AppCompatActivity() {

    private val listaNumeros = ArrayList<Double>()
    private lateinit var textViewNumerosAgregadosDesv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desv_estandar)

        val btnRegresarDesv = findViewById<Button>(R.id.btnRegresarDesv)

        val editTextAgregarNumDesv = findViewById<EditText>(R.id.editTextAgregarNumDesv)
        val btnAgregarNumDesv = findViewById<Button>(R.id.btnAgregarNumDesv)
        val btnCalcularDesv = findViewById<Button>(R.id.btnCalcularDesv)
        val textViewMostrarDesv = findViewById<TextView>(R.id.textViewMostrarDesv)

        textViewNumerosAgregadosDesv = findViewById(R.id.textViewNumerosAgregadosDesv)

        btnAgregarNumDesv.setOnClickListener {
            val numero = editTextAgregarNumDesv.text.toString().toDoubleOrNull()
            if (numero != null) {
                listaNumeros.add(numero)
                editTextAgregarNumDesv.text.clear()
                textViewNumerosAgregadosDesv.append("$numero" + ", ")
                btnCalcularDesv.isEnabled = true
            } else {
                Toast.makeText(this, "Ingresa un número válido", Toast.LENGTH_SHORT).show()
            }
        }

        btnCalcularDesv.setOnClickListener {
            val promedio = listaNumeros.average()
            val sumatoria = listaNumeros.fold(0.0) { acc, i -> acc + (i - promedio) * (i - promedio) }
            val desviacion = sqrt(sumatoria / (listaNumeros.size - 1))
            textViewMostrarDesv.text = "La desviación estándar es: $desviacion"
        }

        btnRegresarDesv.setOnClickListener{
            val intent = Intent(this@DesvEstandar, Welcome::class.java)
            startActivity(intent)
        }
    }
}