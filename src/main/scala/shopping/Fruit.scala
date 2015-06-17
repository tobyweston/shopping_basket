package shopping

sealed trait Fruit {
  val price: Int
}

case class Banana(price: Int) extends Fruit
case class Apple(price: Int) extends Fruit
case class Pineapple(price: Int) extends Fruit
