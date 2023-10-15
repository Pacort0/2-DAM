package com.example.appcalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appcalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val usuario = "ziskito"
    val passwrd = "1234"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Creamos la variable binding para esta actividad
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Cuando pulsemos el botón de Acceder:
        binding.btnAcceder.setOnClickListener {
            //Si alguno de los dos campos no coincide en el usuario o la contraseña, muestra un mensaje de error
            if(binding.campoUsuario.text.toString() != usuario || binding.campoContrasena.text.toString() != passwrd){
                Toast.makeText(this, "Error, datos incorrectos", Toast.LENGTH_SHORT).show()
            } else {
                //Si no, pasamos a la pantalla de la calculadora
                val intent = Intent(this, CalculadoraActivity::class.java)
                startActivity(intent)
            }
        }
    }
}