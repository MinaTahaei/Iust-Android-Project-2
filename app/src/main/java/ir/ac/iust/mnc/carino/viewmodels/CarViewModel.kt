package ir.ac.iust.mnc.carino.viewmodels

import androidx.lifecycle.ViewModel
import ir.ac.iust.mnc.carino.data.Car
import ir.ac.iust.mnc.carino.data.CarRepository

class CarViewModel(private val carRepository: CarRepository): ViewModel() {

    fun getCars() = carRepository.getCars()

    fun addCar(car: Car) = carRepository.addCar(car)

    fun initializeFakeData() {
        val car1: Car = Car("Ferrari", 12500.0);
        val car2: Car = Car("Mercedes-Benz", 10500.0);
        val car3: Car = Car("Aston Martin", 12250.0);
        val car4: Car = Car("Jack", 11500.0);

        this.addCar(car1)
        this.addCar(car2)
        this.addCar(car3)
        this.addCar(car4)
    }

}