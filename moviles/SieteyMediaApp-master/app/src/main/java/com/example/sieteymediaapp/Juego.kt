package com.example.sieteymediaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.example.sieteymediaapp.databinding.ActivityJuegoBinding
import kotlin.random.Random

class Juego : AppCompatActivity() {
    //Variable global para poder acceder a ellas desde las funciones
    var puntos = 0.00 //Lleva la suma de los puntos que va acumulando cada jugador
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Creamos el valor binding para acceder a los elementos del xml de la aplicación
        val bindingJuego = ActivityJuegoBinding.inflate(layoutInflater)
        setContentView(bindingJuego.root)

        val nombreJug1 = intent.getStringExtra("usuario1") //Guardamos el nombre del jug1
        val nombreJug2 = intent.getStringExtra("usuario2") //Guardamos el nombre del jug2
        var recordJug1 = intent.getIntExtra("recordJug1", 0) //Guardamos el record del jug1
        var recordJug2 = intent.getIntExtra("recordJug2", 0) //Guardamos el record del jug2
        var puntosJug1 = 0.00 //Variable para almacenar los puntos del jug1
        var puntosJug2: Double //Variable para almacenar los puntos del jug2
        var otraVez = 0 //Variable para determinar si se vuelve a jugar o no

        //Mostramos que es el turno del jug1
        bindingJuego.turnoJug.text = "Turno de $nombreJug1"
        bindingJuego.recordJug1.text =
            "Record de $nombreJug1: $recordJug1" //Mostramos los records de ambos jugadores
        bindingJuego.recordJug2.text = "Record de $nombreJug2: $recordJug2"
        bindingJuego.btnPlantarseJug2.isEnabled =
            false //Desactivamos los botones del jugador que no juega este turno
        bindingJuego.btnUnaCartaJug2.isEnabled = false

        //Cuando se pulse el botón para sacar una carta
        bindingJuego.btnUnaCartaJug1.setOnClickListener {
            //Si los puntos no superan los 7.5 puntos
            if (puntos <= 7.5) {
                //Se suman los puntos
                puntos = sumaPuntos(puntos)
                //Se actualizan los puntos en pantalla
                bindingJuego.puntosJugAct.text = "Puntos: $puntos"
            } else {
                //Si se han superado los 7.5 puntos, se muestra un mensaje
                Toast.makeText(this, "Te has pasado makinote", Toast.LENGTH_SHORT).show()
                bindingJuego.btnPlantarseJug1.isEnabled =
                    false //Se desactivan los botones del jug1
                bindingJuego.btnUnaCartaJug1.isEnabled = false
                bindingJuego.btnPlantarseJug2.isEnabled = true //Se activan los botones del jug2
                bindingJuego.btnUnaCartaJug2.isEnabled = true
                bindingJuego.turnoJug.text =
                    "Turno de $nombreJug2" //Se dice que es el turno del jug2
                bindingJuego.puntosJug1.text =
                    "Puntos de $nombreJug1: $puntos" //Se asignan los puntos al jug1
                puntosJug1 = puntos //Se guardan los puntos del jug1
                bindingJuego.linearLayout.rotation =
                    0f //Se cambia la rotación del layout de los puntos
                puntos = 0.00 //Se resetean los puntos
            }
        }
        //Si se pulsa el botón para plantarse
        bindingJuego.btnPlantarseJug1.setOnClickListener {
            bindingJuego.btnPlantarseJug1.isEnabled = false
            bindingJuego.btnUnaCartaJug1.isEnabled = false
            bindingJuego.btnPlantarseJug2.isEnabled = true
            bindingJuego.btnUnaCartaJug2.isEnabled = true
            bindingJuego.turnoJug.text = "Turno de $nombreJug2"
            bindingJuego.puntosJug1.text = "Puntos de $nombreJug1: $puntos"
            puntosJug1 = puntos
            bindingJuego.linearLayout.rotation = 0f
            puntos = 0.00
        }

        //Cuando el jug2 pulse el botón de jugar una carta
        bindingJuego.btnUnaCartaJug2.setOnClickListener {
            if (puntos <= 7.5) {
                puntos = sumaPuntos(puntos)
                bindingJuego.puntosJugAct.text = "Puntos: $puntos"
            } else {
                Toast.makeText(this, "Te has pasado makinote", Toast.LENGTH_SHORT).show()
                bindingJuego.puntosJug2.text = "Puntos de $nombreJug2: $puntos"
                bindingJuego.btnPlantarseJug2.isEnabled = false
                bindingJuego.btnUnaCartaJug2.isEnabled = false
                puntosJug2 = puntos
                //Se muestran los botones de 'jugar otra vez'
                bindingJuego.btnJugarOtraVezJug1.visibility = View.VISIBLE
                bindingJuego.btnJugarOtraVezJug2.visibility = View.VISIBLE
                //Guardamos el texto que indica quién ha ganado llamando a una función
                val textoGanador = quienGana(puntosJug1, puntosJug2, nombreJug1, nombreJug2)
                //Mostramos quién ha ganado
                bindingJuego.turnoJug.text = "$textoGanador"
                //Llamamos a la variable y guardamos quién ha ganado
                val jugGanador = jugGana(puntosJug1, puntosJug2)
                //Si ha ganado el jug1, se suma una victoria a su record, si ha ganado el 2, se la sumamos a él
                if (jugGanador == 1) {
                    recordJug1 += 1
                } else if (jugGanador == 2) {
                    recordJug2 += 1
                }
            }
        }
        //Cuando se pulse el botón para plantarse
        bindingJuego.btnPlantarseJug2.setOnClickListener {
            bindingJuego.puntosJug2.text = "Puntos de $nombreJug2: $puntos"
            bindingJuego.btnPlantarseJug2.isEnabled = false
            bindingJuego.btnUnaCartaJug2.isEnabled = false
            puntosJug2 = puntos
            bindingJuego.btnJugarOtraVezJug1.visibility = View.VISIBLE
            bindingJuego.btnJugarOtraVezJug2.visibility = View.VISIBLE
            val textoGanador = quienGana(puntosJug1, puntosJug2, nombreJug1, nombreJug2)
            bindingJuego.turnoJug.text = "$textoGanador"
            val jugGanador = jugGana(puntosJug1, puntosJug2)
            if (jugGanador == 1) {
                recordJug1 += 1
            } else if (jugGanador == 2) {
                recordJug2 += 1
            }
        }

        //Si el jug1 pulsa para jugar otra vez
        bindingJuego.btnJugarOtraVezJug1.setOnClickListener {
            //Sumamos +1 en la variable 'otraVez'
            otraVez += 1
            //Cambiamos el texto del botón
            bindingJuego.btnJugarOtraVezJug1.text = "Esperando al otro jugador..."
            //No se puede clickar más el botón
            bindingJuego.btnJugarOtraVezJug1.isClickable = false
            //Llamamos a la función
            otraVez(otraVez, recordJug1, recordJug2)
        }

        bindingJuego.btnJugarOtraVezJug2.setOnClickListener {
            otraVez += 1
            bindingJuego.btnJugarOtraVezJug2.text = "Esperando al otro jugador..."
            bindingJuego.btnJugarOtraVezJug2.isClickable = false
            otraVez(otraVez, recordJug1, recordJug2)
        }

    }

    /**
     * Función 'sumaPuntos', que recibe por parámetros los puntos del turno actual
     * y le suma un valor numérico aleatorio entre el 0.5 y 7
     * Devuelve una variable con los puntos resultantes
     */
    private fun sumaPuntos(puntosRN: Double): Double {
        var numrandom = Random.nextInt(1, (10 + 1))
        var puntos = puntosRN
        if (puntosRN <= 7.5) {
            if (numrandom in 8..10) {
                puntos += 0.5
            } else {
                puntos += numrandom
            }
        }
        return puntos
    }

    /**
     * Función 'quienGana', que recibe por parámeros los puntos de los jugadores y sus puntos
     * Determina qué jugador ha ganado y se altera una variable String
     * Devuelve una string con el texto ganador
     */
    private fun quienGana(
        puntosJug1: Double, puntosJug2: Double, nombreJ1: String?, nombreJ2: String?): String {
        var gana = ""
        if ((puntosJug1 > puntosJug2) && puntosJug1 <= 7.5 || (puntosJug1 <= 7.5 && puntosJug2 > 7.5)) {
            gana = "Ha ganado $nombreJ1"
        } else if ((puntosJug1 < puntosJug2) && puntosJug2 <= 7.5 || (puntosJug2 <= 7.5 && puntosJug1 > 7.5)) {
            gana = "Ha ganado $nombreJ2"
        } else if ((puntosJug1 > 7.5 && puntosJug2 > 7.5) || puntosJug1 == puntosJug2) {
            gana = "Sois malisimos ambos"
        }
        return gana
    }

    /**
     * Función 'jugGana', que recibe por parámetros los puntos de ambos jugadores y determina quién ha ganado
     * Devuelve un entero en función de quién ha ganado, o si se ha empatado
     */
    private fun jugGana(puntosJug1: Double, puntosJug2: Double): Int {
        var ganador = 0
        if ((puntosJug1 > puntosJug2) && puntosJug1 <= 7.5 || (puntosJug1 <= 7.5 && puntosJug2 > 7.5)) {
            ganador = 1
        } else if ((puntosJug1 < puntosJug2) && puntosJug2 <= 7.5 || (puntosJug2 <= 7.5 && puntosJug1 > 7.5)) {
            ganador = 2
        }
        return ganador
    }

    /**
     * Función 'otraVez', que recibe una variable que determina si ambos jugadores quieren jugar de nuevo,
     * así como los records de cada uno.
     * Si ambos quieren jugar de nuevo, finaliza la actividad y la reinicia con los records actualizados
     */
    private fun otraVez(otraVez: Int, recordJug1: Int, recordJug2: Int) {
        if (otraVez == 2) {
            finish()
            intent.putExtra("recordJug1", recordJug1)
            intent.putExtra("recordJug2", recordJug2)
            startActivity(intent)
        }
    }
}
