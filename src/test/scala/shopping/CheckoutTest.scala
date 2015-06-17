package shopping

import org.specs2.mutable.Specification

class CheckoutTest extends Specification {

  "A checkout can total a sequence of fruit" >> {
    Checkout.price(List(Banana, Banana)) must_== Banana.price * 2
  }
}