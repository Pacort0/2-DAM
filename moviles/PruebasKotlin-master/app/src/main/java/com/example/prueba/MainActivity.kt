package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.prueba.databinding.OtraVistaBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pedrito = OtraVistaBinding.inflate(layoutInflater)

        setContentView(pedrito.root)

        pedrito.miguecabezon.text= "Migue PELATE"

        pedrito.btn.setOnClickListener {
            Toast.makeText(
                applicationContext, "Me has pulsao maquina", Toast.LENGTH_SHORT
            ).show()
        }
    }
}
