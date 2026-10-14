package bike

abstract class Bike (val id: BikeId) {
    abstract val kind: BikeKind
    open fun isReadyToRent(): Boolean = true
    open fun describe(): String = "${id.code} ${kind.name.lowercase()}"
}