package ir.ac.iust.mnc.carino.data

class CarRepository private constructor(private val carDao: FakeCarDao){

    fun addCar(car: Car){
        carDao.addCar(car)
    }

    fun getCars() = carDao.getCars()

    fun getCar(id: Int): Car {
        return carDao.getCar(id)
    }

    companion object {
        // single-tone
        @Volatile private var instance: CarRepository? = null

        fun getInstance(carDao: FakeCarDao) = instance ?: synchronized(lock=this) {
            instance ?: CarRepository(carDao).also { instance = it }
        }
    }
}