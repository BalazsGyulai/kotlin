package strategy

import bike.BikeKind

interface PricingStrategy {
    val label: String
    fun priceInCents(kind: BikeKind, minutesRidden: Int): Long
}