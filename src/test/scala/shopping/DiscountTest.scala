package shopping

import org.specs2.mutable.Specification

class TwoForOneTest extends Specification {

  "Discount applies for multiples of two" >> {
    val fruit = new Fruit(1) with TwoForOne
    fruit.discountFor(Seq()) must_== 0
    fruit.discountFor(Seq(fruit)) must_== 0
    fruit.discountFor(Seq(fruit, fruit)) must_== 1
    fruit.discountFor(Seq(fruit, fruit, fruit)) must_== 1
    fruit.discountFor(Seq(fruit, fruit, fruit, fruit)) must_== 2
    fruit.discountFor(Seq(fruit, fruit, fruit, fruit, fruit)) must_== 2
  }

  "Discount doesn't apply for edge cases" >> {
    val withoutDiscount = new Fruit(10) {}
    val withDiscount = new Fruit(15) with TwoForOne
    withoutDiscount.discountFor(Seq(withDiscount, withDiscount)) must_== 0
    withDiscount.discountFor(Seq(withDiscount, withoutDiscount)) must_== 0
  }

  "Discount doesn't apply for two different types of fruit that have the 'two for one' offer (heterogeneous collection)" >> {
    val kiwi = new Fruit(1) with TwoForOne
    val pear = new Fruit(1) with TwoForOne
    kiwi.discountFor(Seq(pear, pear)) must_== 0
    kiwi.discountFor(Seq(kiwi, kiwi)) must_== 1
    kiwi.discountFor(Seq(kiwi, kiwi, pear, pear)) must_== 1
  }
}

class ThreeForTwoTest extends Specification {
  "Discount applies for multiples of three" >> {
    val fruit = new Fruit(1) with ThreeForTwo
    fruit.discountFor(Seq()) must_== 0
    fruit.discountFor(Seq(fruit)) must_== 0
    fruit.discountFor(Seq(fruit, fruit)) must_== 0
    fruit.discountFor(Seq(fruit, fruit, fruit)) must_== 1
    fruit.discountFor(Seq(fruit, fruit, fruit, fruit)) must_== 1
    fruit.discountFor(Seq(fruit, fruit, fruit, fruit, fruit)) must_== 1
    fruit.discountFor(Seq(fruit, fruit, fruit, fruit, fruit, fruit)) must_== 2
  }

  "Discount doesn't apply for edge cases" >> {
    val withoutDiscount = new Fruit(10) {}
    val withDiscount = new Fruit(15) with ThreeForTwo
    withoutDiscount.discountFor(Seq(withDiscount, withDiscount, withDiscount)) must_== 0
  }

  "Discount doesn't apply for two different types of fruit that have the 'three for two' offer (heterogeneous collection)" >> {
    val kiwi = new Fruit(1) with ThreeForTwo
    val pear = new Fruit(1) with ThreeForTwo
    kiwi.discountFor(Seq(pear, pear)) must_== 0
    kiwi.discountFor(Seq(kiwi, kiwi, kiwi)) must_== 1
    kiwi.discountFor(Seq(kiwi, kiwi, kiwi, pear, pear, pear)) must_== 1
  }
}