package com.example.Tarea_Operaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Factorial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factorial)

        // Obtener una referencia al EditText con el id txtNumero en la vista
        val txtNumero = findViewById<EditText>(R.id.txtNumero)
        // Obtener una referencia al botón con el id btnBoton en la vista
        val btnBoton = findViewById<Button>(R.id.btnBoton)
        // Obtener una referencia al TextView con el id lblResultado en la vista
        val lblResultado = findViewById<TextView>(R.id.lblResultado)

        // Agregar un OnClickListener al botón para manejar su evento de clic
        btnBoton.setOnClickListener {
            // Obtener el valor del EditText como cadena de texto
            val inputValue = txtNumero.text.toString()

            // Intentar convertir el valor de entrada a un número entero
            try {
                val numberValue = inputValue.toInt()
                // Mostrar un Toast con el número ingresado y su factorial
                Toast.makeText(this, "El número ingresado es: " + factorial(numberValue), Toast.LENGTH_SHORT).show()
                // Establecer el texto del TextView para mostrar el número ingresado y su factorial
                lblResultado.text = "El número ingresado es: " + factorial(numberValue)
            } catch (e: NumberFormatException) {
                // Mostrar un Toast y establecer el texto del TextView para indicar que se debe ingresar un número válido
                Toast.makeText(this, "Ingrese un número válido", Toast.LENGTH_SHORT).show()
                lblResultado.text = "Ingrese un número válido"
            }
        }
    }

    fun factorial(numero: Int):Int{
        var resultado = 1;
        // Si el usuario ingresa el número 5, entonces 1..numero representa el rango {1, 2, 3, 4, 5}
        for(x in 1 .. numero){
            resultado *= x;
        }
        return resultado;
    }

}