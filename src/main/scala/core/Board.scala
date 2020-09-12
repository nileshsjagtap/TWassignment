package core

case class Board(listOfCordinates: Seq[String])

object Board {

  def apply(x: Int = 10, y:Int = 10) : Board = {
    val res: Seq[String] = for{
      xc <- 1 to x
      yc <- 1 to y
      ch = 64 + yc
    } yield (ch.toChar.toString+xc.toString)
    Board(res)
  }

  def checkForBoardSize(board: Board, x:Int, y:Int) = {
    board.listOfCordinates.contains((64+y).toChar.toString+x.toString)
  }
}
