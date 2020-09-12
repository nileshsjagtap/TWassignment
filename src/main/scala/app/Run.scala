package app

import core.Game.Result
import core.{Board, Game, Ship}

object Run extends App{

  val board = Board(10, 10)
  val ships = Ship.placeShip(board).toList
  println("positions of ships :"+ ships.map(_.position))
//  val shots = List("A1", "A2", "A3", "B1", "H1", "G4", "C7", "E5", "F8", "J4", "H3", "I LOSE")
//  shots.map(shot => Game.start1(ships,board,shot))

  println("Enter a Coordinate : ")
  val shot = scala.io.StdIn.readLine()
  val res = Game.start1(ships, board, shot)
  println(res.res)
  iterate(res)

  def iterate(res: Result) : String = res.res match {
    case str if(str != "Hit" && str !="Miss") => res.res
    case _ => {
      println("Enter a Coordinate : ")
      val shot = scala.io.StdIn.readLine()
      val result = Game.start1(res.updatedShips, board, shot)
      println(result.res)
      iterate(result)
    }
  }

}
