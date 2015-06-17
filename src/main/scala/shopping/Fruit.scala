package shopping

sealed abstract class Fruit(val price: Pence) extends Discount

case object Banana extends Fruit(51)
case object Apple extends Fruit(12) with TwoForOne
case object Pineapple extends Fruit(95) with TwoForOne
case object Orange extends Fruit(32)

trait Discount {
  def discountFor(count: Int): DiscountInPence = 0
}

trait TwoForOne extends Discount { self: Fruit =>
  override def discountFor(count: Int): DiscountInPence = {
    if (count % 2 == 0) self.price else 0
  }
}