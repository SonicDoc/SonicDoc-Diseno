package com.example.sonicdocv2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.sonicdocv2.R
import com.example.sonicdocv2.models.Reserva
import kotlinx.android.synthetic.main.prototype_reserva.view.*

class ReservaAdapter(val reservas: List<Reserva>) : RecyclerView.Adapter<ReservaAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.prototype_reserva, parent, false)
        )
    }

    override fun getItemCount() = reservas.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val reserva = reservas[position]
        holder.view.Nombres.text = reserva.Nombre
        holder.view.Fecha.text = reserva.Fecha
        holder.view.Turno.text = reserva.Turno
        holder.view.textViewIsNew.visibility = if(reserva.Estado == 1) View.VISIBLE else View.INVISIBLE

        var img = R.drawable.hombre
        if(reserva.Estado!=1){
            img = R.drawable.mujer
        }
        holder.view.imageUser.setImageResource(img)
    }

    class UserViewHolder(val view: View) : RecyclerView.ViewHolder(view)

}