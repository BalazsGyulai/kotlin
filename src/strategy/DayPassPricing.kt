package strategy

import bike.BikeKind

class DayPassPricing : PricingStrategy {
    override val label: String
        get() = "day pass"

    override fun priceInCents(kind: BikeKind, minutesRidden: Int): Long {
        return 1500
    }
}