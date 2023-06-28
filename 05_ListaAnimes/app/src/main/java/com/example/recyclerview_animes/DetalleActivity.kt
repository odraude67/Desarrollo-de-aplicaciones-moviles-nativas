package com.example.recyclerview_animes

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail)

        val titulo = intent.getStringExtra("titulo")
        val descripcion = intent.getStringExtra("descripcion")
        val imagen = intent.getIntExtra("imagen", 0)

        val tituloTextView: TextView = findViewById(R.id.tituloDetalleTextView)
        val descripcionTextView: TextView = findViewById(R.id.descripcionDetalleTextView)
        val imagenImageView: ImageView = findViewById(R.id.imagenDetalleImageView)
        imagenImageView.setImageResource(imagen)

        tituloTextView.text = titulo
        descripcionTextView.text = descripcion
        imagenImageView.setImageResource(imagen)
    }
}
