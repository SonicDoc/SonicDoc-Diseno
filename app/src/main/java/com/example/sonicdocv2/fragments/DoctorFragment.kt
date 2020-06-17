package com.example.sonicdocv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.sonicdocv2.R
import com.example.sonicdocv2.adapters.DoctorAdapter
import com.example.sonicdocv2.adapters.OnDoctorClickListener
import com.example.sonicdocv2.models.Doctor
import kotlinx.android.synthetic.main.fragment_doctor.*

class DoctorFragment : Fragment(), OnDoctorClickListener  {
    // TODO: Rename or Delete types of and its parameters
    private var param1: String? = null
    private var param2: String? = null

    private val TAG = "DoctorFragment"
    //lateinit var doctores : ArrayList<Doctor>
    //lateinit var listaDoctor : List<Doctor>
    lateinit var doctorAdapter: DoctorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_doctor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listaDoctor: ArrayList<Doctor> = ArrayList()
        doctorAdapter = DoctorAdapter(listaDoctor, this)
        recyclerViewDoctor.adapter = doctorAdapter
        recyclerViewDoctor.layoutManager = LinearLayoutManager(context)
        for(num in 1..7){
            listaDoctor.add(Doctor(num,"Dr Tetas ${num}", "Ginecología"))
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment.
         */
        @JvmStatic
        fun newInstance() =
            DoctorFragment().apply {
                //return DoctorFragment()
            }
    }

    //TODO qué hacer con el dato del click
    override fun onItemClicked(doctor: Doctor) {
        TODO("Not yet implemented")
    }
}
