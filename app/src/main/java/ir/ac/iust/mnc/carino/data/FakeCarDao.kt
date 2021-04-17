package ir.ac.iust.mnc.carino.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeCarDao {
    // simple version
    private val carList = mutableListOf<Car>()
    private val cars = MutableLiveData<List<Car>>()

    init {
        cars.value = carList
    }

    fun addCar(car: Car) {
        carList.add(car)
        cars.value = carList
    }

    fun getCars() = cars as LiveData<List<Car>>
}