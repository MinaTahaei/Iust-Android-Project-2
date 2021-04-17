package ir.ac.iust.mnc.carino.data

data class Car(val name: String, val price: Double) {
    // simple version
    override fun toString(): String {
        return name
    }
}