package com.example.sonicdocv2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sonicdocv2.R
import com.example.sonicdocv2.models.Doctor
import kotlinx.android.synthetic.main.prototype_doctor.view.*

class DoctorAdapter(val doctores: List<Doctor>, val itemClickListerner: OnDoctorClickListener) : RecyclerView.Adapter<DoctorPrototype>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorPrototype {
        val view = LayoutInflater.
        from(parent.context).
        inflate(R.layout.prototype_doctor,parent,false)

        return DoctorPrototype(view)
    }

    override fun getItemCount(): Int{
        return doctores.size
    }

    override fun onBindViewHolder(holder: DoctorPrototype, position: Int) {
        holder.bind(doctores[position], itemClickListerner)
    }
}


class DoctorPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //TODO crear layout prototipo y asignar estos textViews a variables
    val tvName = itemView.Nombres
    val tvEspecialidad = itemView.Especialidad

    fun bind(doctor : Doctor, itemClickListener: OnDoctorClickListener) {
        tvName.text = doctor.Nombre
        tvEspecialidad.text = doctor.Especialidad

        itemView.setOnClickListener {
            itemClickListener.onItemClicked(doctor)
        }
    }
}

interface OnDoctorClickListener {
    fun onItemClicked(doctor: Doctor)
}