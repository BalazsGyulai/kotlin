package command

import strategy.DayPassPricing
import strategy.HourlyPricing
import strategy.MemberPricing
import strategy.RentalStation

class PricingCommand(val station: RentalStation) : Command {
    override fun execute() {
        print("pricing (1 = hourly, 2 = member, 3 = day pass): ")
        val pricingOption = readln().toInt()

        try {
            when (pricingOption) {
                1 -> station.changePricing(HourlyPricing())
                2 -> station.changePricing(MemberPricing())
                3 -> station.changePricing(DayPassPricing())
                else -> throw IllegalStateException("unknown pricing option '${pricingOption}'")
            }

            println("pricing is now ${station.pricing.label}")
        } catch (e: IllegalStateException) {
            println("error: ${e.message}")
        }


    }

}