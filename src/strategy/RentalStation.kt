package strategy

import bike.Bike
import bike.BikeId
import bike.BikeKind
import kotlin.math.max

class RentalStation(pricing: PricingStrategy, initialBikeList: List<Bike>) {
    private val bikes: MutableList<Bike> = initialBikeList.toMutableList()
    private val activeRentals: MutableList<Rental> = mutableListOf()
    var pricing = pricing
        private set
    var revenueInCents: Long = 0
        private set

    fun addBike(bike: Bike) {
        require(bikes.contains(bike)){"duplicate bike id ${bike.id.code}"}

        bikes.add(bike)
    }

    fun changePricing(newPricing: PricingStrategy) {
        pricing = newPricing
    }

    fun allBikes(): List<Bike> = bikes

    fun isRented(id: BikeId): Boolean = _isBikeIdInRented(id)

    fun rent(id: BikeId, customerName: String): Rental {
        require(customerName.isNotEmpty()){"customer name must not be blank"}
        require(_isBikeIdInBikes(id)){"unknown bike ${id.code}"}
        require(!isRented(id)){"bike ${id.code} is already rented"}

        val rental = Rental(_getBikeFromBikes(id), customerName)
        activeRentals.add(rental)
        return rental
    }

    fun returnBike(id: BikeId, minutesRidden: Int): Receipt {
        require(minutesRidden > 0){"minutes must be positive, was ${minutesRidden}"}
        require(isRented(id)){"bike ${id.code} is not rented"}

        val rental = _getBikeFromRentals(id)
        val priceInCents = pricing.priceInCents(rental.bike.kind, minutesRidden)

        revenueInCents += priceInCents


        return Receipt(
            rental.bike.id,
            rental.customerName,
            minutesRidden,
            pricing.label,
            priceInCents
        )
    }

    private fun _getBikeFromBikes(id: BikeId): Bike {
        var offset = 0
        while (offset < bikes.size) {
            if (bikes[offset].id.code == id.code) {
                break
            }
            offset += 1
        }

        return bikes[offset]
    }

    private fun _getBikeFromRentals(id: BikeId): Rental {
        var offset = 0
        while (offset < activeRentals.size) {
            if (activeRentals[offset].bike.id.code == id.code) {
                break
            }
            offset += 1
        }

        return activeRentals[offset]
    }

    private fun _isBikeIdInBikes(id: BikeId): Boolean {
        var offset = 0
        var found = false
        while (!found && offset < bikes.size) {
            if (bikes[offset].id.code == id.code) found = true
            offset += 1
        }

        return found
    }

    private fun _isBikeIdInRented(id: BikeId): Boolean {
        var offset = 0
        var found = false
        while (!found && offset < activeRentals.size) {
            if (activeRentals[offset].bike.id.code == id.code) found = true
            offset += 1
        }

        return found
    }
}