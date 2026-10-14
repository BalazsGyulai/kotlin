package bike

class ElectricBike(id: BikeId, val batteryPercent: Int) : Bike(id) {
    init {
        require(batteryPercent in 0..100){"Battery percent must be between [0 and 100], was ${batteryPercent}"}
    }

    private val MIN_BATTERY_PERCENT_TO_RENT = 20

    override val kind: BikeKind
        get() = BikeKind.ELECTRIC

    override fun isReadyToRent(): Boolean = batteryPercent >= MIN_BATTERY_PERCENT_TO_RENT

    override fun describe(): String {
        return super.describe() + " battery (${batteryPercent}%)"
    }

}