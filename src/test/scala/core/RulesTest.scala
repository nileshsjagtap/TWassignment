package core

import org.specs2.mutable.Specification

class RulesTest extends Specification {

  "Rules" should {
    "Return true when player hits ship" in {
        val expected = true
        val ships: List[Ship] = List(Carrier.copy(position = Some("D2")), Battleship.copy(position = Some("H2")))
        val res = Rules.hit(ships)("H2")
        res must beEqualTo(expected)
    }
    "Return false when player hits ship" in {
        val expected = false
        val ships: List[Ship] = List(Carrier.copy(position = Some("D2")), Battleship.copy(position = Some("H2")))
        val res = Rules.hit(ships)("C2")
        res must beEqualTo(expected)
    }
    "Return true when player misses ship" in {
        val expected = true
        val ships: List[Ship] = List(Carrier.copy(position = Some("D2")), Battleship.copy(position = Some("H2")))
        val res = Rules.miss(ships)("C2")
        res must beEqualTo(expected)
    }
    "Return false when player hits ship" in {
        val expected = false
        val ships: List[Ship] = List(Carrier.copy(position = Some("D2")), Battleship.copy(position = Some("H2")))
        val res = Rules.miss(ships)("D2")
        res must beEqualTo(expected)
    }
    "Return true if all the ships are sunk" in {
        val expected = true
        val ships: List[Ship] = List(Carrier.copy(shot = true), Battleship.copy(shot = true))
        val res = Rules.sunk(ships)
        res must beEqualTo(expected)
    }
    "Return false if all the ships are not sunk" in {
        val expected = false
        val ships: List[Ship] = List(Carrier.copy(shot = false), Battleship.copy(shot = true))
        val res = Rules.sunk(ships)
        res must beEqualTo(expected)
    }
  }

}
