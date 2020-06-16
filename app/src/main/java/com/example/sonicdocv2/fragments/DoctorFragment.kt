package com.example.sonicdocv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.sonicdocv2.R
import com.example.sonicdocv2.adapters.DoctorAdapter
import com.example.sonicdocv2.models.Doctor
import kotlinx.android.synthetic.main.fragment_doctor.*

//TODO (implement recyclerview's OnItemClickListener)
class DoctorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_doctor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listaDoctor: ArrayList<Doctor> = ArrayList()
        recyclerViewDoctor.layoutManager = LinearLayoutManager(context)
        recyclerViewDoctor.adapter = DoctorAdapter(listaDoctor)
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
}
