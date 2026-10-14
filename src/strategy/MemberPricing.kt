package strategy

import bike.BikeKind

class MemberPricing : PricingStrategy {
    override val label: String
        get() = "member"

    override fun priceInCents(kind: BikeKind, minutesRidden: Int): Long {
        var startedHours: Int = 0
        val minutesRiddenWithoutBonus = minutesRidden - 30

        while (minutesRiddenWithoutBonus - startedHours * 60 > 0) {
            startedHours += 1
        }

        return startedHours * kind.ratePerStartedHourInCents
    }
}