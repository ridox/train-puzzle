import scala.collection.mutable.ListBuffer

case class Program() {

  private val commands = ListBuffer.empty[(Int, TrainCommand)]
  private var commandId: Int = 0

  def nextCommand(command: TrainCommand): Program = {
    commands += ((commandId, command))
    commandId += 1
    this
  }

  def build: List[(Int, TrainCommand)] = commands.toList

}
