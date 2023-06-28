package com.example.listafrases

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var frasesListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frasesListView = findViewById(R.id.frasesListView)

        val listaFrases = obtenerListaDeFrases()
        val adapter = FraseAdapter(this, listaFrases)
        frasesListView.adapter = adapter
    }

    private fun obtenerListaDeFrases(): List<Frase> {
        return listOf(
            Frase("Sócrates", "Sólo sé que no sé nada."),
            Frase("Sócrates", "La vida examinada no merece ser vivida."),
            Frase("René Descartes", "Cogito, ergo sum."),
            Frase("Aristóteles", "La ética es el arte de vivir bien."),
            Frase("Protágoras", "El hombre es la medida de todas las cosas."),
            Frase("Platón", "La música es para el alma lo que la gimnasia para el cuerpo."),
            Frase("Friedrich Nietzsche", "Lo que no te mata, te hace más fuerte."),
            Frase("Jean-Paul Sartre", "La existencia precede a la esencia."),
            Frase("Confucio", "Elige un trabajo que te guste, y no tendrás que trabajar ni un día de tu vida."),
            Frase("Baruch Spinoza", "No hay vicio del entendimiento que no tenga su origen en un vicio del corazón.")
        )
    }

    private inner class FraseAdapter(
        context: Context,
        private val listaFrases: List<Frase>
    ) : BaseAdapter(), ListAdapter {

        private val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int {
            return listaFrases.size
        }

        override fun getItem(position: Int): Any {
            return listaFrases[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val rowView = convertView ?: inflater.inflate(R.layout.item_frase, parent, false)

            val autorTextView = rowView.findViewById<TextView>(R.id.autorTextView)
            val fraseTextView = rowView.findViewById<TextView>(R.id.fraseTextView)

            val frase = listaFrases[position]
            autorTextView.text = frase.autor
            fraseTextView.text = frase.contenido

            return rowView
        }
    }
}
