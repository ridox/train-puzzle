class TrainProcessor(val t1: Train, val t2: Train) {

  private var commands = List.empty[(Int, TrainCommand)]

  //TODO it might be moved to constructor
  def runProgram(program: Program) = {
    commands = program.build

    var nextCommandId = 0

    while (nextCommandId < commands.length) {
      nextCommandId = executeCommand(commands(nextCommandId))
      if (t1.position == 0) println("Station") else println("Tchyh")
    }

  }

  def executeCommand(idAndCommand: (Int, TrainCommand)): Int =
    idAndCommand match {
      case (commandId, Left()) => {
        t1.moveLeft
        commandId + 1
      }
      case (commandId, Right()) => {
        t1.moveRight
        commandId + 1
      }
      case (_, GoTo(goToLabel)) =>
        commands.filter(_._2.label == goToLabel).map(_._1).head
      case (commandId, IfStation(command)) =>
        if (t1.position == 0) executeCommand((commandId, command))
        else commandId + 1
    }

}
