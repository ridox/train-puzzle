object App {

  def main(args: Array[String]): Unit = {
    val tp = new TrainProcessor(new Train(-1), new Train(1))
    val run = Program()

    //TODO think how to remove "run nextCommand" boilerplate
    tp.runProgram {
      run nextCommand "1" :: Right()
      run nextCommand IfStation {GoTo("4")}
      run nextCommand GoTo("1")
      run nextCommand "4" :: Right()
      run nextCommand Right()
      run nextCommand GoTo("4")
    }
  }

}
