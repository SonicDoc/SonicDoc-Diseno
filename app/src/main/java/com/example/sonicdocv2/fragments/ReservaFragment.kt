package com.example.sonicdocv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sonicdocv2.R
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//TODO (implement recyclerview's OnItemClickListener)
class ReservaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_reserva, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO(RecyclerView)
        //initialize recyclerView
        //load data with cargar_citas
    }

    //TODO (call API)
    private fun cargar_citas() {
        val retrofit = Retrofit.Builder()
            .baseUrl("192.168.0.3:5000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment
         */

        @JvmStatic
        fun newInstance() =
            ReservaFragment().apply {
                //return ReservaFragment()
            }
    }
}
