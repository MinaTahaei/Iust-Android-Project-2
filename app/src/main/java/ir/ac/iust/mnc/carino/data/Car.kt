package ir.ac.iust.mnc.carino.data

data class Car(val name: String, val year: Int, val company: String, val kilometer: Double, val image_path: String) {
    // simple version
    override fun toString(): String {
        return name
    }
}