package ir.ac.iust.mnc.carino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.ac.iust.mnc.carino.data.Car
import ir.ac.iust.mnc.carino.utils.InjectorUtils
import ir.ac.iust.mnc.carino.viewmodels.CarViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUI()
    }

    private fun initializeUI(){
        val factory = InjectorUtils.provideCarViewModelFactory()
        val viewModel = ViewModelProvider(this, factory).get(CarViewModel::class.java)
        viewModel.initializeFakeData()
        // TODO: Extend 'Car' class due to project's doc
        Log.i("MainActivity", "initializeUI: fetched cars from factory!")
        viewModel.getCars().observe(this, Observer {cars ->
            cars.forEach{car ->
                Log.i("MainActivity", "initializeUI: $car")
            }
        })
    }
}