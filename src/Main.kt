import bike.Bike
import bike.BikeId
import bike.CargoBike
import bike.CityBike
import bike.ElectricBike
import strategy.HourlyPricing
import strategy.MemberPricing
import strategy.RentalStation
import java.io.File

fun main(args: Array<String>) {
    val pathname = if (args.size >= 1) args[0] else "docs/station.txt"
    val parser = StationFileParser()
    val bikeList: List<Bike> = try{ File(pathname).useLines{
        parser.parse(it.map { it.substringBefore("#").trim() })
    }} catch (e: IllegalStateException) {
        error("Cannot load ${pathname}: ${e.message}")
    }

    println("Loaded ${bikeList.size} bikes from ${pathname} (pricing: hourly)")
    val stationConsole = StationConsole(RentalStation(HourlyPricing(), bikeList))
    stationConsole.run()
}