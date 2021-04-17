package ir.ac.iust.mnc.carino.data

class FakeDatabase private constructor(){

    var carDao = FakeCarDao()
        private set

    companion object {
        // single-tone
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(lock=this) {
            instance ?: FakeDatabase().also { instance = it }
        }
    }
}