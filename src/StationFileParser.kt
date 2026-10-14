import bike.Bike
import bike.BikeId
import bike.CargoBike
import bike.CityBike
import bike.ElectricBike

class StationFileParser {
    fun parse(lines: Sequence<String>): List<Bike> {
        val iterator = lines.withIndex().iterator()
        val bikeList: MutableList<Bike> = mutableListOf()

        while (iterator.hasNext()){
            val iteratorItem = iterator.next()

            if (iteratorItem.value.isNotEmpty()) {
                val tokenList = iteratorItem.value.split(";")
                    .map { it.trim() }

                val bike = when (tokenList[0]) {
                    "CITY" -> CityBike(BikeId(tokenList[1]))
                    "CARGO" -> CargoBike(BikeId(tokenList[1]))
                    "ELECTRIC" -> ElectricBike(BikeId(tokenList[1]), tokenList[2].toInt())
                    else -> throw IllegalStateException("line ${iteratorItem.index + 1}: unknown bike kind '${tokenList[0]}'")
                }

                bikeList.add(bike)
            }

        }

        return bikeList
    }
}