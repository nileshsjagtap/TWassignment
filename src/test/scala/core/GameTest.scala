package core

import org.specs2.mutable.Specification

class GameTest extends Specification {

  "Game" should {
    "return Sink if all ships are sunk" in {
      val expected = "Sink"
      val ships = List(Carrier.copy(position = Some("D2"), shot = false), Battleship.copy(position = Some("H2"), shot = false), Submarine.copy(position = Some("E8"),  shot = false))
      val board = Board(10, 10)
      val shots = List("A1", "H2", "E8", "D2")
      val res = Game.start(ships, board, shots)
      res must beEqualTo(expected)
    }

    "return Ships positions if input is I Lose" in {
      val expected = s"""Ship positions are ${List("D2", "H2", "E8")}"""
      val ships = List(Carrier.copy(position = Some("D2"), shot = false), Battleship.copy(position = Some("H2"), shot = false), Submarine.copy(position = Some("E8"), shot = false))
      val board = Board(10, 10)
      val shots = List("A1", "H2", "I LOSE")
      val res = Game.start(ships, board, shots)
      res must beEqualTo(expected)
    }

  }

}
