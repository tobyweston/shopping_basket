package shopping

import org.specs2.mutable.Specification

class CheckoutTest extends Specification {

  "A checkout can total a sequence of fruit" >> {
    Checkout.price(List(Banana, Banana)) must_== Banana.price * 2
  }
}

object Checkout {

  def price(items: Seq[Fruit]): Int = {
    items.foldLeft(0)(_ + _.price)
  }
}