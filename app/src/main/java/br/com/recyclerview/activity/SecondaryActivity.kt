package br.com.recyclerview.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.recyclerview.R
import br.com.recyclerview.adapter.AdapterCar
import br.com.recyclerview.databinding.ActivitySecondaryBinding
import br.com.recyclerview.helper.RecyclerViewItemClickListener
import br.com.recyclerview.model.Car

class SecondaryActivity : AppCompatActivity(), AdapterView.OnItemClickListener,
    RecyclerViewItemClickListener.OnItemClickListener {
    private lateinit var binding: ActivitySecondaryBinding
    private var listCar = getAllCars()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
    }

    private fun getAllCars(): ArrayList<Car> {
        val carA = Car(99, "Fiat", "Sedan")
        val carB = Car(100, "GM", "Pickup")
        val carC = Car(101, "Ford", "hatch")

        return arrayListOf(carA, carB, carC)
    }

    private fun initRecyclerView() {
        val adapterCar = AdapterCar(listCar)

        with(binding) {
            recyclerViewCar.layoutManager = LinearLayoutManager(this@SecondaryActivity)
            recyclerViewCar.setHasFixedSize(true)
            recyclerViewCar.adapter = adapterCar

            // evento de click
            recyclerViewCar.addOnItemTouchListener(
                RecyclerViewItemClickListener(
                    applicationContext,
                    recyclerViewCar,
                    this@SecondaryActivity
                )
            )
        }
    }

    override fun onItemClick(view: View?, position: Int) {
        val car: Car = listCar.get(position)
        Toast.makeText(applicationContext, "Clique rápido: " + car.brand, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onLongItemClick(view: View?, position: Int) {
        val car: Car = listCar.get(position)
        Toast.makeText(applicationContext, "Clique longo: " + car.brand, Toast.LENGTH_SHORT).show()
    }
}