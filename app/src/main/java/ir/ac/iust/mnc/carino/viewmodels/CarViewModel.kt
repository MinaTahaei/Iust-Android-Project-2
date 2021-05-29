package ir.ac.iust.mnc.carino.viewmodels

import androidx.lifecycle.ViewModel
import ir.ac.iust.mnc.carino.data.Car
import ir.ac.iust.mnc.carino.data.CarRepository

class CarViewModel(private val carRepository: CarRepository): ViewModel() {

    fun getCars() = carRepository.getCars()

    fun getCar(id: Int): Car {
        return carRepository.getCar(id)
    }

    fun addCar(car: Car) = carRepository.addCar(car)

    fun initializeFakeData() {
        val car1 = Car("Bronco Sport", 2021, "Ford", 30000.0,  "https://public-iust-ai.s3.ir-thr-at1.arvanstorage.com/ford.jpg");
        val car2 = Car("Escape", 2021, "Ford", 0.0, "https://public-iust-ai.s3.ir-thr-at1.arvanstorage.com/ford2.jpg");
        val car3 = Car("Yaris", 2020, "Mercedes-Benz", 5000.0, "https://public-iust-ai.s3.ir-thr-at1.arvanstorage.com/2019_toyota_yaris_sedan_xle_fq_oem_1_815.jpg");
//        val car4: Car = Car("Jack",,,, );

        this.addCar(car1)
        this.addCar(car2)
        this.addCar(car3)
//        this.addCar(car4)
    }

}