class TrainProcessor(val t1: Train, val t2: Train) {

  private var commands = List.empty[(Int, TrainCommand)]

  //TODO it might be moved to constructor
  def runProgram(program: Program) = {
    commands = program.build

    var nextCommandIdTrain1 = 0
    var nextCommandIdTrain2 = 0

    while (nextCommandIdTrain1 < commands.length && nextCommandIdTrain2 < commands.length && t1.position != t2.position) {
      nextCommandIdTrain1 = executeCommand(t1, commands(nextCommandIdTrain1))
      nextCommandIdTrain2 = executeCommand(t2, commands(nextCommandIdTrain2))
      println("Tchyh")
      println(s"Train 1 pos:${t1.position}")
      println(s"Train 2 pos:${t2.position}")
      if (t1.position == t2.position) println("Boom!!!")
    }
  }

  def executeCommand(train: Train, idAndCommand: (Int, TrainCommand)): Int =
    idAndCommand match {
      case (commandId, Left()) => {
        train.moveLeft
        commandId + 1
      }
      case (commandId, Right()) => {
        train.moveRight
        commandId + 1
      }
      case (_, GoTo(goToLabel)) => {
        commands
          .filter(t =>
            t match {
              case (_, command) => command.label.getOrElse("") == goToLabel
          })
          .map(e => e._1)
          .head
      }
      case (commandId, IfStation(command)) =>
        if (train.position == 0)
          executeCommand(train, (commandId, command))
        else commandId + 1
    }
}
