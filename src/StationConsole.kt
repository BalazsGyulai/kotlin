import command.ExitCommand
import command.ListCommand
import command.PricingCommand
import command.RentCommand
import command.ReturnCommand
import command.RevenueCommand
import strategy.RentalStation

class StationConsole(val station: RentalStation) {
    private var programRunning = true
    fun run() {
        while (programRunning) {
            println(_showCommands())
            print("> ")
            val input = try {
                _readInput()
            } catch (e: NumberFormatException) {
                println("Please provide a valid number")
            }

            when (input) {
                0 -> ExitCommand(::stopProgram).execute()
                1 -> ListCommand(station).execute()
                2 -> RentCommand(station).execute()
                3 -> ReturnCommand(station).execute()
                4 -> PricingCommand(station).execute()
                5 -> RevenueCommand(station).execute()
                else -> println("unknown option '${input}'")
            }
        }

        println("bye")
    }

    fun stopProgram(){
        programRunning = false
    }

    private fun _showCommands(): String {
        return "[1] list\t[2] rent\t[3] return\t[4] pricing\t[5] revenue\t[0] exit"
    }

    private fun _readInput(): Int {
        return readln().trim().toInt()
    }
}