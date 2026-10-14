package bike

class CargoBike(id: BikeId) : Bike(id) {
    override val kind: BikeKind
        get() = BikeKind.CARGO
}