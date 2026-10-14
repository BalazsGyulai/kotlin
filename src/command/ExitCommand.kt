package command

class ExitCommand(val stopFunction: () -> Unit) : Command {
    override fun execute() {
        stopFunction()
    }
}