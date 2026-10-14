package strategy

import bike.BikeKind

class HourlyPricing : PricingStrategy {
    override val label: String
        get() = "hourly"

    override fun priceInCents(kind: BikeKind, minutesRidden: Int): Long {
        var startedHours: Int = 0

        while (minutesRidden - startedHours * 60 > 0) {
            startedHours += 1
        }

        return startedHours * kind.ratePerStartedHourInCents
    }
}