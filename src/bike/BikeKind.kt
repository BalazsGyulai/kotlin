package bike

enum class BikeKind(val ratePerStartedHourInCents: Long) {
    CITY(200),
    ELECTRIC(350),
    CARGO(500)
}