package bike

class CityBike(id: BikeId) : Bike(id) {
    override val kind: BikeKind
        get() = BikeKind.CITY
}