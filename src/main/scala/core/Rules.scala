package core

object Rules {

  def hit = (ships: List[Ship]) => (position: String) =>
    ships.map(_.position.get).contains(position)


  def miss = (ships: List[Ship]) => (position: String) => {
    !(hit(ships)(position))
  }

  def lose(str: String) = {
    Ship.getShips.map(_.position).map(a => a.get).mkString
  }

  def sunk = (ships : List[Ship]) => {
    ships.filter(_.shot == true).size == ships.size
    ships.forall(_.shot == true)
  }

}
