object App {

  def main(args: Array[String]): Unit = {
    val tp = new TrainProcessor(new Train(-1), new Train(2))
    val run = Program()

    //TODO think how to remove "run nextCommand" boilerplate
    tp.runProgram {
      run nextCommand "a" :: Right()
      run nextCommand GoTo("a")
      run nextCommand IfStation { Left () }
      //run nextCommand GoTo("a")
      /*run nextCommand Left()
      run nextCommand Right()
      run nextCommand "asd" :: Right()
      run nextCommand IfStation { Left() }
      run nextCommand GoTo("asd")*/
    }
  }

}
