package com.example.sieteymediaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sieteymediaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingLogin = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingLogin.root)

        //Cuando se pulse el botón para empezar a jugar
        bindingLogin.btnEmpezar.setOnClickListener {
            if (bindingLogin.campoJug1.text.toString()
                    .isEmpty() || bindingLogin.campoJug2.text.toString().isEmpty() //Si alguno de los campos de jugador está vacío
            ) {
                //Muestra un mensaje de error
                Toast.makeText(this, "Tiene que haber dos jugadores", Toast.LENGTH_SHORT).show()
            } else {
                //Si ambos están rellenados, pasamos a la siguiente actividad
                val intent = Intent(this, Juego::class.java) //Creamos el intent
                intent.putExtra("usuario1", bindingLogin.campoJug1.text.toString()) //Pasamos el nombre del jug1
                intent.putExtra("usuario2", bindingLogin.campoJug2.text.toString()) //Pasamos el nombre del jug2
                startActivity(intent)
            }
        }
    }

}