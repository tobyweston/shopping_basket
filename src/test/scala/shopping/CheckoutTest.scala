package shopping

import org.specs2.mutable.Specification

class CheckoutTest extends Specification {

  "A checkout can total a sequence of fruit" >> {
    Checkout.price(List(Banana, Banana)) must_== Banana.price * 2
  }

  "Applies a discount (buy one, get one free) on Apples" >> {
    Checkout.price(List(Apple, Apple)) must_== Apple.price
    Checkout.price(List(Apple, Apple, Pineapple)) must_== Apple.price + Pineapple.price
  }

  "Applies a discount (three for two) on Bananas" >> {
    Checkout.price(List(Banana, Banana, Banana)) must_== Banana.price * 2
    Checkout.price(List(Banana, Banana, Banana, Banana, Banana)) must_== Banana.price * 4
    Checkout.price(List(Banana, Banana, Banana, Apple)) must_== Banana.price * 2 + Apple.price
  }
}