package ir.ac.iust.mnc.carino.viewmodels

import androidx.lifecycle.ViewModel
import ir.ac.iust.mnc.carino.data.Car
import ir.ac.iust.mnc.carino.data.CarRepository

class CarViewModel(private val carRepository: CarRepository): ViewModel() {

    fun getCars() = carRepository.getCars()

    fun addCar(car: Car) = carRepository.addCar(car)

    fun initializeFakeData() {
        val car1 = Car("Peykan Vanet", 1384, "Peykan", 300000.0,  "https://s100.divarcdn.com/static/pictures/1620035501/AYG22fRN.webp");
        val car2 = Car("Quick R", 1400, "Sipa", 0.0, "https://s100.divarcdn.com/static/pictures/1620035497/AYPi4BU4.webp");
        val car3 = Car("Benze Class E 240", 2003, "Mercedes-Benz", 50000.0, "https://s100.divarcdn.com/static/pictures/1620035462/AY9NUTj0.webp");
//        val car4: Car = Car("Jack",,,, );

        this.addCar(car1)
        this.addCar(car2)
        this.addCar(car3)
//        this.addCar(car4)
    }

}