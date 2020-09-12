package core

import org.specs2.mutable.Specification

class ShipTest extends Specification {

  "Ship" should {
    "place all the ships on board and return them with their position" in {
      val expected = ""
      val board = Board(10, 10)
      val ships = Ship.getShips
      val res = Ship.placeShip(board)
      res must beEqualTo(expected)
      //true equals(true)
    }

    "should return all ships" in {
      val expected = List(Ship("Carrier",5,None,false), Ship("Battleship",4,None,false), Ship("Submarine",3,None,false), Ship("Patrol",2,None,false))
      val res = Ship.getShips
      res must beEqualTo(expected)
    }

    "should change status of ship" in {
      val expected = Ship("Carrier",5, Some("D2"),true)
      val res = Ship.changeStatus(Ship("Carrier",5,Some("D2"),false), "D2")
      res must beEqualTo(expected)
    }

  }

}
