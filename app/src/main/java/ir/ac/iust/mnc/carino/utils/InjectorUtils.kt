package ir.ac.iust.mnc.carino.utils

import ir.ac.iust.mnc.carino.data.CarRepository
import ir.ac.iust.mnc.carino.data.FakeDatabase
import ir.ac.iust.mnc.carino.viewmodels.CarsViewModelFactory

object InjectorUtils {

    fun provideCarViewModelFactory(): CarsViewModelFactory {
        // dependency injection
        val carRepository = CarRepository.getInstance(FakeDatabase.getInstance().carDao)
        return CarsViewModelFactory(carRepository)
    }
}