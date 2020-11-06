package br.com.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.recyclerview.R
import br.com.recyclerview.model.Car

class AdapterCar(private val listCars: ArrayList<Car>) :
    RecyclerView.Adapter<AdapterCar.CarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCar.CarViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterCar.CarViewHolder, position: Int) {
        val car: Car = listCars.get(position)
        holder.brandCar.text = car.brand
    }

    override fun getItemCount() = listCars.size

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val brandCar: TextView = itemView.findViewById(R.id.text_name_car)
    }
}