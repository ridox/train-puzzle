class Train(var position: Long) {
  def moveLeft: Unit = position -= 1
  def moveRight: Unit = position += 1
}
