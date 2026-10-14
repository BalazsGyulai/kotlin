package command

import bike.BikeId
import strategy.RentalStation

class RentCommand(val station: RentalStation) : Command {
    override fun execute() {
        print("bike id: ")
        val bikeId = BikeId(readln())

        print("customer: ")
        val customer = readln()

        try {
            val rental = station.rent(bikeId, customer)
            println("${rental.customerName} rented ${rental.bike.describe()}")
        } catch (e: Exception){
            println("error: ${e.message}")
        }

    }
}