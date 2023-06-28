package com.ipn.mx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var frase : EditText
    lateinit var autor : EditText
    lateinit var btnGuardar : Button
    lateinit var btnListado : Button
    lateinit var tvDatos : TextView
    lateinit var texto : String
    lateinit var db : SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frase = findViewById(R.id.txtFrase)
        autor = findViewById(R.id.txtAutor)

        btnGuardar = findViewById(R.id.btnAceptar)
        btnListado = findViewById(R.id.btnListado)

        tvDatos = findViewById(R.id.tvDatos)
        texto = ""

        db = SQLiteHelper(this)

        btnGuardar.setOnClickListener(){
            val laFrase = frase.text.toString()
            val elAutor = autor.text.toString()

            //pasa a un instancia de la clase
            val f = Frase(laFrase, elAutor)

            val almacenado = db.create(f)
            //ya ha insertado
            if(almacenado == true){
                Toast.makeText(this,"ok",Toast.LENGTH_SHORT).show()
                frase.text.clear()
                autor.text.clear()//limpia caja
            }
            //revisar text: textUtils
        }

        btnListado.setOnClickListener(){
            Toast.makeText(this,"Listado",Toast.LENGTH_SHORT).show()
            muestraTabla()

            //monada si no funciona lo corrigen
            val cursor = db.readAll()
            val sb = StringBuilder() //concatena cosas con manera de API
            while (cursor.moveToNext()){
                sb.append("frase : ").append(cursor.getString(1)).append("\n")
                sb.append("autor : ").append(cursor.getString(2)).append("\n")
            }//String objeto/clase - no primativo: ocupa append(x: int)(x: String)(x: Object), string builder optimizado - sobre escrito
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Listado")
            alertDialog.setMessage(sb.toString())
            alertDialog.show()
        }



    }

    fun muestraTabla(){
        val cursor = db.readAll()
        val numeroFilas : Int = cursor.count
        cursor.moveToFirst()
        for(i in 1 .. numeroFilas){
            var id : Int = cursor.getInt(0)
            var frase : String = cursor.getString(1)
            var autor : String = cursor.getString(2)
            texto = texto + "\n" + id + ", " + frase + ", " + autor + "\n"
            cursor.moveToNext()
        }
        tvDatos.append(texto)

    }
}