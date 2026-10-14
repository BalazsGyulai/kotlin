package strategy

import bike.BikeId

data class Receipt(
    val bikeId: BikeId,
    val customerName: String,
    val minutesRidden: Int,
    val pricingLabel: String,
    val priceInCents: Long
)
