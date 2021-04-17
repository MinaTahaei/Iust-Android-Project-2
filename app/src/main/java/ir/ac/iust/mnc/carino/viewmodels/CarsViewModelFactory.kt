package ir.ac.iust.mnc.carino.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ir.ac.iust.mnc.carino.data.CarRepository

class CarsViewModelFactory(private val carRepository: CarRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CarViewModel(carRepository) as T
    }
}