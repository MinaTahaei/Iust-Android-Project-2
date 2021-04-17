package ir.ac.iust.mnc.carino.viewmodels

import androidx.lifecycle.ViewModel
import ir.ac.iust.mnc.carino.data.Car
import ir.ac.iust.mnc.carino.data.CarRepository

class CarViewModel(private val carRepository: CarRepository): ViewModel() {

    fun getCars() = carRepository.getCars()

    fun addCar(car: Car) = carRepository.addCar(car)

}