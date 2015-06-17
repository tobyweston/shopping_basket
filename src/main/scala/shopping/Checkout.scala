package shopping

object Checkout {

  def price(items: Seq[Fruit]): Int = {
    val discounts = items.groupBy(identity).map({ case (fruit, fruits) => fruit.discountFor(fruits.size) })
    items.map(_.price).sum - discounts.sum
  }
}
