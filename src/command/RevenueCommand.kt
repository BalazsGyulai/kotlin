package command

import strategy.RentalStation

class RevenueCommand(val station: RentalStation) : Command {
    override fun execute() {
        println("revenue: ${station.revenueInCents / 100}.${station.revenueInCents % 100} EUR")
    }
}