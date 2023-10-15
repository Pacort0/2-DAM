package com.example.ejemplorv

import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.ejemplorv.databinding.ItemcontactoBinding

class ContactosAdapter(private val contactos : List<Contacto>,
    private val contactoPulsadoListener: ContactoPulsadoListener)
    :RecyclerView.Adapter<ContactosAdapter.ViewHolder>(){
    class ViewHolder(val binding : ItemcontactoBinding )
        :RecyclerView.ViewHolder(binding.root){
        fun bind(contacto:Contacto){
            binding.nombre.text = contacto.nombre
            binding.info.text = contacto.tlfn
            if (contacto.genero == "fem"){
                binding.fotoperfil.setImageResource(R.drawable.fotomujer)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemcontactoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int { //Devuelve el tamaño de la lista que le pasemos al adapter
        return contactos.size
    }

    //Recibe un ViewHolder y la posición en la lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Creamos una variable transitionInflater, a la que le pasamos el contexto de la app y la transición que deseamos hacer
        val fadeTransition = TransitionInflater.from(holder.itemView.context).inflateTransition(android.R.transition.fade)
        //Creamos una lista de palabras con los nombres y apellidos de cada contacto
        var palabras = contactos[position].nombre.split(" ")
        var iniciales = "" //Variable que usaremos para guardar las iniciales de los contactos
        for (palabra in palabras){ //Bucle for para recorrer los nombres de los usuarios
            iniciales += palabra.substring(0, 1) //Sacamos la primera letra de cada palabra
        }
        holder.binding.iniciales.text = iniciales.uppercase() //Ponemos las iniciales como texto y las pasamos a mayúscula
        holder.bind(contactos[position]) //Mostramos el contacto correspondiente en cada posición
        holder.itemView.setOnClickListener {
            contactoPulsadoListener.contactoPulsado(contactos[position])
        }
        //Si se pulsa la foto de perfil
        holder.binding.fotoperfil.setOnClickListener {
            //Usamos la transición creada anteriormente
            TransitionManager.beginDelayedTransition(holder.itemView as ViewGroup?, fadeTransition)
            //Si las iniciales están en pantalla, las volvemos invisibles para mostrar todos los datos
            if (holder.binding.iniciales.isVisible) {
                holder.binding.iniciales.visibility = View.GONE
            } else { //Si ya están ocultas, las mostramos de nuevo
                holder.binding.iniciales.visibility = View.VISIBLE
            }
        }
    }
}

