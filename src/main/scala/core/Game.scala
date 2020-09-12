package core

case class Game(ships: List[Ship], board: Board, shots: List[String])

object Game {

  def start(ships: List[Ship], board: Board, shots: List[String]): String = shots match {
    case Nil  => if(Rules.sunk(ships)) "Sink" else shotsAndShipsInfo(ships,board,shots)
    case h :: t if(board.listOfCordinates.contains(h) && Rules.hit(ships)(h)) => {println("Hit"); start(changeStatus(ships, h), board, t)}
    case h :: t if(board.listOfCordinates.contains(h) && Rules.miss(ships)(h)) => {println("Miss"); start(ships,board,t)}
    case h :: _ if(h == "I LOSE") => shotsAndShipsInfo(ships,board,shots)
  }

  def start1(ships: List[Ship], board: Board, shot: String, shotsHistory : List[String] = List.empty[String]) = shot match {
    case o if(board.listOfCordinates.contains(shot) && Rules.hit(ships)(shot)) => {if(Rules.sunk(changeStatus(ships, o))) Result("Sink", ships) else Result("Hit", changeStatus(ships, o))}
    case p if(board.listOfCordinates.contains(shot) && Rules.miss(ships)(shot)) => Result("Miss", ships)
    case "I LOSE" => Result(shotsAndShipsInfo(ships, board, shotsHistory), ships)
    case _ => Result("Invalid Shot", ships)
  }

  def changeStatus(ships: List[Ship], shot: String) = {
    ships.map(a => Ship.changeStatus(a, shot))
  }

  def shotsAndShipsInfo(ships: List[Ship], board: Board, shots: List[String]) = {
    s"""Ship positions are ${ships}, shots are ${shots}"""
  }

  case class Result(res: String, updatedShips: List[Ship])

}
