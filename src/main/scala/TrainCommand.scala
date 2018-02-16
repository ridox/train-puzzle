trait TrainCommand {
  var label: Option[String] = None

  def ::(label: String): TrainCommand = {
    this.label = Some(label)
    this
  }
}

case class Left() extends TrainCommand
case class Right() extends TrainCommand
case class GoTo(goToLabel: String) extends TrainCommand
case class IfStation(command: TrainCommand) extends TrainCommand