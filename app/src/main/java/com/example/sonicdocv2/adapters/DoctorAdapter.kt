package com.example.sonicdocv2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sonicdocv2.R
import com.example.sonicdocv2.models.Doctor
import kotlinx.android.synthetic.main.prototype_doctor.view.*

class DoctorAdapter(val doctores: List<Doctor>) : RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder{
        return DoctorViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.prototype_doctor , parent, false)
        )
    }

    override fun getItemCount() = doctores.size

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        val doctor = doctores[position]
        holder.view.Nombres.text = doctor.Nombre
        holder.view.Especialidad.text = doctor.Especialidad

    }
    class DoctorViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}