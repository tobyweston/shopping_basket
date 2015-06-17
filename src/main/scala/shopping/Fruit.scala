package shopping

abstract class Fruit(val price: Pence) extends Discount

case object Banana extends Fruit(51) with ThreeForTwo
case object Apple extends Fruit(12) with TwoForOne
case object Pineapple extends Fruit(95)
case object Orange extends Fruit(32)

trait Discount {
  def discountFor(fruit: Seq[Fruit]): DiscountInPence = 0
}

trait TwoForOne extends Discount { self: Fruit =>
  override def discountFor(fruit: Seq[Fruit]): DiscountInPence = fruit.count(_ == self) / 2 * self.price
}

trait ThreeForTwo extends Discount { self: Fruit =>
  override def discountFor(fruit: Seq[Fruit]): DiscountInPence = fruit.count(_ == self) / 3 * self.price
}