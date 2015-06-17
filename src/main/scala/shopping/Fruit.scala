package shopping

sealed abstract class Fruit(val price: Pence) extends Discount

case object Banana extends Fruit(51)
case object Apple extends Fruit(12) with TwoForOne
case object Pineapple extends Fruit(95)
case object Orange extends Fruit(32)

trait Discount {
  def discountFor(fruit: Seq[Fruit]): DiscountInPence = 0
}

trait TwoForOne extends Discount {
  override def discountFor(fruit: Seq[Fruit]): DiscountInPence = {
    if (fruit.count(_ == Apple) % 2 == 0) Apple.price else 0
  }
}