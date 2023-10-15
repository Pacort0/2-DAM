package com.example.appcalculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.appcalculadora.databinding.ActivityCalculadoraBinding

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingCalculadora = ActivityCalculadoraBinding.inflate(layoutInflater)
        setContentView(bindingCalculadora.root)

        bindingCalculadora.btnAtras.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        bindingCalculadora.btnSuma.setOnClickListener {
            val operando1 = bindingCalculadora.campoPrimerFact.text.toString()
            val operando2 = bindingCalculadora.campoSegundoFact.text.toString()
            if (!estaVacio(operando1, operando2)){
                val num1 = operando1.toDouble()
                val num2 = operando2.toDouble()
                 val suma = num1 + num2
                bindingCalculadora.campoResultado.text = "$suma"
            } else {
                bindingCalculadora.campoResultado.text = "Resultado = 0"
                Toast.makeText(this, "Introduzca ambos valores", Toast.LENGTH_SHORT).show()
            }
        }
        bindingCalculadora.btnResta.setOnClickListener {
            val operando1 = bindingCalculadora.campoPrimerFact.text.toString()
            val operando2 = bindingCalculadora.campoSegundoFact.text.toString()
            if (!estaVacio(operando1, operando2)){
                val num1 = operando1.toDouble()
                val num2 = operando2.toDouble()
                val resta = num1 - num2
                bindingCalculadora.campoResultado.text = "$resta"
            } else {
                bindingCalculadora.campoResultado.text = "Resultado = 0"
                Toast.makeText(this, "Introduzca ambos valores", Toast.LENGTH_SHORT).show()
            }
        }
        bindingCalculadora.btnMultiplicacion.setOnClickListener {
            val operando1 = bindingCalculadora.campoPrimerFact.text.toString()
            val operando2 = bindingCalculadora.campoSegundoFact.text.toString()
            if (!estaVacio(operando1, operando2)){
                val num1 = operando1.toDouble()
                val num2 = operando2.toDouble()
                val multiplicacion = num1 * num2
                bindingCalculadora.campoResultado.text = "$multiplicacion"
            } else {
                bindingCalculadora.campoResultado.text = "Resultado = 0"
                Toast.makeText(this, "Introduzca ambos valores", Toast.LENGTH_SHORT).show()
            }
        }
        bindingCalculadora.btnDivision.setOnClickListener {
            val operando1 = bindingCalculadora.campoPrimerFact.text.toString()
            val operando2 = bindingCalculadora.campoSegundoFact.text.toString()
            if (!estaVacio(operando1, operando2) && operando2.toDouble() != 0.00){
                val num1 = operando1.toDouble()
                val num2 = operando2.toDouble()
                val division = num1 / num2
                bindingCalculadora.campoResultado.text = "$division"
            } else {
                bindingCalculadora.campoResultado.text = "Resultado = 0"
                Toast.makeText(this, "Introduzca valores correctos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun estaVacio(operando1:String, operando2:String):Boolean{
        var vacio = false
        if(operando1.isEmpty() or operando2.isEmpty()){
            vacio = true
        }
        return vacio
    }
}