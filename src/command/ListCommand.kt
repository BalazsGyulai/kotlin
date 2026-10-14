package command

import bike.Bike
import strategy.RentalStation

class ListCommand(val station: RentalStation) : Command {
    override fun execute() {
        val bikeList = station.allBikes()
        for (bike in bikeList){
            val available = if (bike.isReadyToRent()) "available" else "not ready"
            println("${bike.describe()} - $available")
        }
    }
}