package com.example.Tarea_Operaciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Promedio : AppCompatActivity() {

    // almacenará los números ingresados por el usuario
    private val listaNumeros = ArrayList<Double>()
    // mostrará los números ingresados por el usuario en tiempo real.
    private lateinit var textViewNumerosAgregados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promedio)

        val btnRegresarPromedio = findViewById<Button>(R.id.btnRegresarPromedio)

        val editTextAgregarNum = findViewById<EditText>(R.id.editTextAgregarNum)
        val btnAgregarNum = findViewById<Button>(R.id.btnAgregarNum)
        val btnCalcularPromedio = findViewById<Button>(R.id.btnCalcularPromedio)
        val textViewMostrarPromedio = findViewById<TextView>(R.id.textViewMostrarPromedio)

        textViewNumerosAgregados = findViewById(R.id.textViewNumerosAgregados)

        btnAgregarNum.setOnClickListener {
            // el número ingresado por el usuario es convertido a tipo Double
            val numero = editTextAgregarNum.text.toString().toDoubleOrNull()
            // Si el número es válido, se agrega a la lista de números y se limpia el campo de entrada
            if (numero != null) {
                // se agrega el número a la cadena en el TextView textViewNumerosAgregados
                // y se habilita el botón btnCalcularPromedio
                listaNumeros.add(numero)
                editTextAgregarNum.text.clear()
                textViewNumerosAgregados.append("$numero" + ", ")
                btnCalcularPromedio.isEnabled = true
            }
            // Si el número no es válido, se muestra un Toast con un mensaje de error
            else {
                Toast.makeText(this, "Ingresa un número válido", Toast.LENGTH_SHORT).show()
            }
        }

        btnCalcularPromedio.setOnClickListener {
            // se calcula el promedio de los números en la lista utilizando la función average
            val promedio = listaNumeros.average()
            // se muestra el resultado en el TextView textViewMostrarPromedio
            textViewMostrarPromedio.text = "El promedio es: $promedio"
        }

        btnRegresarPromedio.setOnClickListener{
            val intent = Intent(this@Promedio, Welcome::class.java)
            startActivity(intent)
        }
    }
}