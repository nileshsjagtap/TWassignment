package core

import org.specs2.mutable.Specification

class BoardTest extends Specification {

  "Board" should {
    "create a board for given coordinates" in {
      val expected = Board(Vector("A1", "B1", "C1", "D1", "E1", "A2", "B2", "C2", "D2", "E2", "A3", "B3", "C3", "D3", "E3", "A4", "B4", "C4", "D4", "E4", "A5", "B5", "C5", "D5", "E5"))
      val res = Board(5, 5)
      res must beEqualTo(expected)
    }

    "return true if given position is in Board" in{
      val expected = true
      val board = Board(5,5)
      val res = Board.checkForBoardSize(board, 3,4)
      res must beEqualTo(expected)
    }

    "return false if given position is not in Board" in{
      val expected = false
      val board = Board(5,5)
      val res = Board.checkForBoardSize(board, 6,7)
      res must beEqualTo(expected)
    }
  }

}
