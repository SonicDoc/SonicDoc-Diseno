package com.example.sonicdocv2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sonicdocv2.R
import com.example.sonicdocv2.models.Reserva
import kotlinx.android.synthetic.main.prototype_reserva.view.*

class ReservaAdapter(val reservas: List<Reserva>, val itemClickListener : OnReservaClickListener) : RecyclerView.Adapter<ReservaPrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservaPrototype {
        val view = LayoutInflater.
        from(parent.context).
        inflate(R.layout.prototype_reserva,parent,false)

        return ReservaPrototype(view)
    }

    override fun getItemCount(): Int {
        return reservas.size
    }

    override fun onBindViewHolder(holder: ReservaPrototype, position: Int) {
        holder.bind(reservas[position], itemClickListener)
    }
}

class ReservaPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvIsNew = itemView.textViewIsNew
    val tvNombre = itemView.Nombres
    val tvFecha = itemView.Fecha
    val tvEspecialidad = itemView.Especialidad

    val tvImgDoctor = itemView.imageDoctor


    fun bind(reserva: Reserva, itemClickListener: OnReservaClickListener) {
        tvNombre.text = reserva.Nombre
        tvFecha.text = reserva.Fecha
        tvEspecialidad.text = reserva.Turno

        tvIsNew.visibility = if(reserva.Estado == 1) View.VISIBLE else View.INVISIBLE

        var img = R.drawable.hombre
        if(reserva.Estado!=1){
            img = R.drawable.mujer
        }
        tvImgDoctor.setImageResource(img)
    }
}

interface OnReservaClickListener {
    fun onItemClicked(reserva: Reserva)
}