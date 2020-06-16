package com.example.sonicdocv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.sonicdocv2.R
import com.example.sonicdocv2.adapters.ReservaAdapter
import com.example.sonicdocv2.models.Reserva
import com.example.sonicdocv2.network.ReservaService
import kotlinx.android.synthetic.main.fragment_reserva.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
        //initialize recyclerView
        var listaReserva: ArrayList<Reserva> = ArrayList()
        recyclerViewReserves.layoutManager = LinearLayoutManager(context)
        recyclerViewReserves.adapter = ReservaAdapter(listaReserva)
        listaReserva.add(Reserva(1,"Gustavo","01/01/01","02/02/02",1,1))
        listaReserva.add(Reserva(2,"Piero","01/01/01","02/02/02",0,0))
        btnCargar.setOnClickListener{
            loadReserva()
        }
    }

    private fun loadReserva(){
        val retrofit = Retrofit.Builder()
            .baseUrl("http://yaderp.com/sonicdoc/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val reservaService:ReservaService
        reservaService = retrofit.create(ReservaService::class.java)
        val request =reservaService.getAll()
        request.enqueue(object : Callback<List<Reserva>> {
            override fun onFailure(call: Call<List<Reserva>>, t: Throwable) {
                Toast.makeText(context,t.message.toString(),Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Reserva>>, response: Response<List<Reserva>>) {
                if(response.isSuccessful){
                    val reservas:List<Reserva> = response.body()!!
                    recyclerViewReserves.layoutManager = LinearLayoutManager(context)
                    recyclerViewReserves.adapter = ReservaAdapter(reservas)
                }
            }
        })
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
