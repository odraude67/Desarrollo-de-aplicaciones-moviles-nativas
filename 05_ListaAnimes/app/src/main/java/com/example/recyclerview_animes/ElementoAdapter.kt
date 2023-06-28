package com.example.recyclerview_animes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ElementoAdapter(
    private val elementos: List<Elemento>,
    private val onItemClick: (Elemento) -> Unit
) : RecyclerView.Adapter<ElementoAdapter.ElementoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ElementoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ElementoViewHolder, position: Int) {
        val elemento = elementos[position]
        holder.bind(elemento)
    }

    override fun getItemCount(): Int {
        return elementos.size
    }

    inner class ElementoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tituloTextView: TextView = itemView.findViewById(R.id.tituloTextView)
        private val descripcionTextView: TextView = itemView.findViewById(R.id.descripcionTextView)
        private val imagenImageView: ImageView = itemView.findViewById(R.id.imagenElementoImageView)

        fun bind(elemento: Elemento) {
            tituloTextView.text = elemento.titulo
            descripcionTextView.text = elemento.descripcion
            imagenImageView.setImageResource(elemento.imagen)

            itemView.setOnClickListener {
                onItemClick(elemento)
            }
        }
    }
}