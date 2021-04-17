package ir.ac.iust.mnc.carino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.ac.iust.mnc.carino.data.Car
import ir.ac.iust.mnc.carino.utils.InjectorUtils
import ir.ac.iust.mnc.carino.viewmodel.CarViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUI()
    }

    private fun initializeUI(){
        val factory = InjectorUtils.provideCarViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(CarViewModel::class.java)

        // TODO: Use a proper method for dummy data
        // TODO: Extend 'Car' class due to project's doc
        val car1: Car = Car("Ferrari", 12500.0);
        val car2: Car = Car("Mercedes-Benz", 10500.0);
        val car3: Car = Car("Aston Martin", 12250.0);
        val car4: Car = Car("Jack", 11500.0);

        viewModel.addCar(car1)
        viewModel.addCar(car2)
        viewModel.addCar(car3)
        viewModel.addCar(car4)

        Log.i("MainActivity", "initializeUI: fetched cars from factory!")
        viewModel.getCars().observe(this, Observer {cars ->
            cars.forEach{car ->
                Log.i("MainActivity", "initializeUI: $car")
            }
        })
    }
}