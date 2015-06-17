package shopping

import org.specs2.mutable.Specification

class CheckoutTest extends Specification {

  "A checkout can total a sequence of fruit" >> {
    Checkout.price(List(Banana, Banana)) must_== Banana.price * 2
  }

  "Applied a discount (buy one, get one free)" >> {
    Checkout.price(List(Apple, Apple)) must_== Apple.price
    Checkout.price(List(Apple, Apple, Banana)) must_== Apple.price + Banana.price
  }
}