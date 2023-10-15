package com.example.ejemplorv

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemplorv.databinding.ActivityContactosBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Creamos un binding para acceder al recyclerView
        val contactos = ActivityContactosBinding.inflate(layoutInflater)
        setContentView(contactos.root)

        //Asignamos al adapter que contiene el elemento RecyclerView, el nuevo Adapter creado
        contactos.listaContactos.adapter = ContactosAdapter(
            //Creamos la lista de contactos (primer parámetro)
            listOf(
                Contacto("Juan Martinez Soria", "624215122", "masc"),
                Contacto("Raúl González", "627482939", "masc"),
                Contacto("Ana Bohueles", "644535636", "fem"),
                Contacto("Eloy","666777888", "masc"),
                Contacto("Pedro", "624215122", "masc"),
                Contacto("Juanma", "627482939", "masc"),
                Contacto("Luisa Gaming Cardozo", "644535636", "fem"),
                Contacto("Migue","666777888", "masc"),
                Contacto("Lola", "624215123", "fem"),
                Contacto("Ignacio", "627482938", "masc"),
                Contacto("Antonio", "644535635", "masc"),
                Contacto("Sara","666777887", "fem"),
                Contacto("Juana", "644535631", "fem"),
                Contacto("Isabel","666777884", "fem"),
                Contacto("Lola", "624215123", "fem"),
                Contacto("Pedro Primo", "627482930", "masc"),
                Contacto("Curro", "644535637", "masc"),
                Contacto("Saray","666777889", "fem"),
            )
            ,

            //Objeto de tipo ContactoPulsadoListener que sobreescribe el evento 'contactoPulsado'
            object : ContactoPulsadoListener {
                override fun contactoPulsado(contacto: Contacto) {
                    //Al pulsar un contacto, nos marca el número para hacer una llamada
                    val dial = Intent(
                        Intent.ACTION_DIAL,
                        Uri.parse("tel: " + contacto.tlfn)
                    )
                    startActivity(dial)
                }
            }
        )
    }

}