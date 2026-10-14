package command

import bike.BikeId
import strategy.RentalStation

class ReturnCommand(val station: RentalStation) : Command {
    override fun execute() {
        print("bike id: ")
        try {
            val bikeId = BikeId(readln())

            print("minutes ridden: ")
            val minutesRidden = readln().toInt()

            try {
                val receipt = station.returnBike(bikeId, minutesRidden)
                println("${receipt.customerName} returned ${receipt.bikeId.code} after ${receipt.minutesRidden} min: ${receipt.priceInCents / 100}.${receipt.priceInCents % 100} EUR (${receipt.pricingLabel})")
            } catch (e: Exception){
                println("error: ${e.message}")
            }

        } catch (e: IllegalArgumentException) {
            println("error: ${e.message}")
        }

    }
}