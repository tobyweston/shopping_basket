package shopping

sealed abstract class Fruit(val price: Pence)
case object Banana extends Fruit(51)
case object Apple extends Fruit(12)
case object Pineapple extends Fruit(95)
case object Orange extends Fruit(32)
