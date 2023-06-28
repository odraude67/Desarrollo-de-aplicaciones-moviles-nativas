package com.example.recyclerview_animes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ElementoAdapter
    private lateinit var elementos: List<Elemento>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtén tus elementos de alguna manera (p. ej., desde una base de datos o una lista estática)
        elementos = obtenerElementos()

        adapter = ElementoAdapter(elementos) { elemento ->
            // Aquí se ejecutará el código cuando se haga clic en un elemento
            // Puedes pasar los datos a la nueva actividad a través de un Intent o mediante ViewModel
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("titulo", elemento.titulo)
            intent.putExtra("descripcion", elemento.descripcion)
            intent.putExtra("imagen", elemento.imagen)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }

    // Esta función obtiene tus elementos (sustituye esto con tu lógica real)
    private fun obtenerElementos(): List<Elemento> {
        return listOf(
            Elemento("Naruto", "Naruto Uzumaki, un joven ninja con sueños de convertirse en Hokage, lucha para proteger su aldea de amenazas externas e internas.", R.drawable.naruto),
            Elemento("One Piece", "Monkey D. Luffy y su tripulación de piratas buscan el tesoro definitivo, conocido como el One Piece, mientras enfrentan peligros y desafíos en el Grand Line.", R.drawable.one_piece),
            Elemento("Attack on Titan", "La humanidad se encuentra amenazada por enormes titanes devoradores de personas. Un grupo de jóvenes valientes se unen para luchar contra ellos y descubrir los secretos de su existencia.", R.drawable.attack_on_titan),
            Elemento("Death Note", "Light Yagami encuentra un cuaderno sobrenatural que le permite matar a cualquier persona cuyo nombre escriba en él. Utiliza el cuaderno para intentar crear un mundo libre de criminales, pero se enfrenta a un detective genio llamado L que intenta detenerlo.", R.drawable.death_note),
            Elemento("Dragon Ball Z", "Goku y sus amigos protegen la Tierra de poderosos enemigos que amenazan con destruirla. A medida que obtienen poderes cada vez más fuertes, se enfrentan a batallas épicas para salvaguardar el planeta.", R.drawable.dragon_ball_z),
            Elemento("Fullmetal Alchemist", "Dos hermanos, Edward y Alphonse Elric, buscan la Piedra Filosofal para restaurar sus cuerpos después de un experimento de alquimia fallido. En su búsqueda, descubren una conspiración más grande que amenaza con desencadenar una guerra.", R.drawable.fullmetal_alchemist),
            Elemento("My Hero Academia", "En un mundo donde la mayoría de las personas tienen superpoderes, Izuku Midoriya lucha por convertirse en un héroe, a pesar de no tener poderes iniciales. Se une a la prestigiosa Academia U.A. y se enfrenta a desafíos para convertirse en el mejor héroe.", R.drawable.my_hero_academia),
            Elemento("Demon Slayer", "Tanjiro Kamado se convierte en un cazador de demonios después de que su familia es asesinada por uno. Busca venganza y también intenta encontrar una cura para su hermana convertida en demonio.", R.drawable.demon_slayer),
            Elemento("Hunter x Hunter", "Gon Freecss se embarca en un viaje para convertirse en un cazador, un título que otorga privilegios y acceso a misteriosos lugares. En su camino, se encuentra con otros aspirantes a cazadores y se enfrenta a peligrosos desafíos.", R.drawable.hunter_x_hunter),
            Elemento("Sword Art Online", "Kirito y otros jugadores quedan atrapados en un juego de realidad virtual llamado Sword Art Online. Deben vencer los niveles y jefes del juego para escapar, enfrentándose a peligros y explorando mundos virtuales.", R.drawable.sword_art_online)
        )
    }

}

