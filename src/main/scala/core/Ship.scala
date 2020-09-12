package core

import scala.util.Random

sealed case class Ship(name: String, size: Int, position: Option[String], shot: Boolean = false)

object Carrier extends Ship("Carrier",5,None)
object Battleship extends Ship("Battleship",4,None)
object Submarine extends Ship("Submarine",3,None)
object Patrol extends Ship("Patrol",2,None)

object Ship {

  def placeShip(board: Board) = {
    val random = new Random()
    val x = random.nextInt(6) + 1
    val y = random.nextInt(6) + 1
    val orientation = random.nextBoolean()
    val ships = getShips

    ((1 to ships.length) zip getShips).map({ (tuple2) =>
      if (Board.checkForBoardSize(board, x, y) && orientation == true)
          tuple2._2.copy(position = Some((x+64).toChar.toString + (tuple2._1+y).toString))
      else
          tuple2._2.copy(position = Some((64+tuple2._1).toChar.toString + y.toString))
    })
  }

  def getShips = List(Carrier, Battleship, Submarine, Patrol)

  def changeStatus(ship: Ship, shot: String) = if (ship.position.get == shot) ship.copy(shot = true) else ship

}
